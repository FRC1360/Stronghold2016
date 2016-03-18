package org.usfirst.frc.team1360.robot;

import org.usfirst.frc.team1360.robot.util.Xbox360Controller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    private static final Xbox360Controller JS_DRIVER = new Xbox360Controller(RobotMap.JOYSTICK_DRIVER, 0.25);
    private static final Xbox360Controller JS_OPERATOR = new Xbox360Controller(RobotMap.JOYSTICK_OPERATOR, 0.25);

    public static double getDriverThrottle()
    {
        return JS_DRIVER.getRightTrigger() - JS_DRIVER.getLeftTrigger();
    }

    public static double getDriverTurn()
    {
        return JS_DRIVER.getLeftXAxis();
    }

    public static boolean getDriverRearTilt()
    {
        return JS_DRIVER.getButtonA();
    }

    public static boolean getOperatorPivotSetpointUp() {return JS_OPERATOR.getButtonX();}

    public static boolean getOperatorPivotSetpointDown()
    {
        return JS_OPERATOR.getButtonY();
    }


    public static double getOperatorIntake()
    {
        return -JS_OPERATOR.getLeftTrigger();
    }

    public static double getOperatorShooterRPM()
    {
        return JS_OPERATOR.getRightTrigger()-JS_OPERATOR.getLeftTrigger();
    }

    public static boolean getOperatorFire()
    {
        return JS_OPERATOR.getButtonA();
    }

    public static boolean getOperatorIntakeToggle()
    {
        return JS_OPERATOR.getButtonStart();
    }

    public static double getOperatorPivot()
    {


        return -(JS_OPERATOR.getRightYAxis()*10);

    }
}

