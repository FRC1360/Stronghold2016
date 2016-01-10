package org.usfirst.frc.team1360.robot.autonomous;

import java.lang.reflect.Constructor;

public class AutonomousManager
{
    private final String AUTONPACKAGE = "org.usfirst.frc.team1360.robot.autonomous.groups.";
    public AutonomousManager()
    {

    }

    public Object getObject(String name) throws ClassNotFoundException, NoSuchMethodException
    {
        Class<?> clazz = Class.forName(AUTONPACKAGE + name);
        Constructor<?> constructor = clazz.getConstructor();
        return null;
    }
}
