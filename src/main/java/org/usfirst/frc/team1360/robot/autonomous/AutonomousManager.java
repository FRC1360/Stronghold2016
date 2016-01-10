package org.usfirst.frc.team1360.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AutonomousManager
{
    private final String AUTONOMOUSPACKAGE = this.getClass().getCanonicalName().replace("AutonomousManager", "");

    public AutonomousManager()
    {

    }

    public Command getAction(String name)
    {
        Class<?> clazz;
        try
        {
            clazz = Class.forName(AUTONOMOUSPACKAGE + name);
            Constructor<?> constructor = clazz.getConstructor();
            return (Command) constructor.newInstance();

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
