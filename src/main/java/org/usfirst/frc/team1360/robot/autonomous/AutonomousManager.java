package org.usfirst.frc.team1360.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1360.robot.util.CommandData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AutonomousManager
{
    private final String AUTONOMOUSPACKAGE = AutonomousManager.class.getCanonicalName().replace("AutonomousManager", "");

    public  Command getAction(String name, CommandData commandData)
    {
        Class<?> clazz;
        try
        {
            clazz = Class.forName(AUTONOMOUSPACKAGE + name);
            Constructor<?> constructor = clazz.getConstructor(CommandData.class);
            return (Command) constructor.newInstance(commandData);

        }
        catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public CommandGroup getGroup(String name, CommandData commandData)
    {
        return (CommandGroup) getAction(name, commandData);
    }
}
