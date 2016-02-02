package main.java.org.usfirst.frc.team1360.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.org.usfirst.frc.team1360.robot.util.CommandData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AutonomousManager
{
    private static final String AUTONOMOUSPACKAGE = AutonomousManager.class.getCanonicalName().replace("AutonomousManager", "");

    public static Command getAction(String name, CommandData commandData)
    {
        Class<?> clazz;
        String path = AUTONOMOUSPACKAGE + name;
        if(!name.contains("groups.") && !name.contains("actions."))
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

    public static CommandGroup getGroup(String name, CommandData commandData)
    {
        return (CommandGroup) getAction("groups." + name, commandData);
    }

}
