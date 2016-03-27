package org.usfirst.frc.team1360.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1360.robot.util.CommandData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public class AutonomousGroupBuilder extends CommandGroup
{
    private HashMap<AutonomousCommand, String> raw;
    private List<Command> commandList;
    private static final String AUTONOMOUSPACKAGE = AutonomousGroupBuilder.class.getCanonicalName().replace("AutonomousGroupBuilder", "");

    public AutonomousGroupBuilder(HashMap<AutonomousCommand, String> raw)
    {
        this.raw = raw;
        parseHashMap();
    }

    public AutonomousGroupBuilder(List<Command> commandList)
    {
        this.commandList = commandList;
        parseList();
    }

    public static CommandGroup getGroup(String name, CommandData commandData)
    {
        return (CommandGroup) getAction("groups." + name, commandData);
    }


    private void parseHashMap()
    {
        for (AutonomousCommand action : raw.keySet())
        {
            String type = raw.get(action);
            if (type.equals("Parallel"))
                addParallel(action);
            else
                addSequential(action);
        }
    }

    private void parseList()
    {
        for (Command c : commandList)
            addSequential(c);
    }


    private static Command getAction(String name, CommandData commandData)
    {
        Class<?> clazz;
        String path = AUTONOMOUSPACKAGE + name;
        if (!name.contains("groups.") && !name.contains("actions."))
            path = AUTONOMOUSPACKAGE + "actions." + name;

        try
        {
            clazz = Class.forName(path);
            Constructor<?> constructor = clazz.getConstructor(CommandData.class);
            return (Command) constructor.newInstance(commandData);
        }
        catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return null;
    }


}
