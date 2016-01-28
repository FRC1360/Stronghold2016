package org.usfirst.frc.team1360.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{

    private static final Joystick JS_DRIVER = new Joystick(RobotMap.JOYSTICK_DRIVER);
    private static final Joystick JS_OPERATOR = new Joystick(RobotMap.JOYSTICK_OPERATOR);

    public static double getDriverLeftTrigger()
    {
        return JS_DRIVER.getRawAxis(2);
    }

    public static double getDriverRightTrigger()
    {
        return JS_DRIVER.getRawAxis(3);
    }

    public static double getOperatorLeftTrigger()
    {
        return JS_OPERATOR.getRawAxis(2);
    }

    public static double getOperatorRightTrigger()
    {
        return JS_OPERATOR.getRawAxis(3);
    }


}

