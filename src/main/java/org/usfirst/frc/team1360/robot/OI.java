package org.usfirst.frc.team1360.robot;

import org.usfirst.frc.team1360.robot.RobotMap;

import org.usfirst.frc.team1360.robot.util.Xbox360Controller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
	//TODO: Deadzone

	private static final Xbox360Controller JS_DRIVER = new Xbox360Controller(RobotMap.JOYSTICK_DRIVER);
	private static final Xbox360Controller JS_OPERATOR = new Xbox360Controller(RobotMap.JOYSTICK_OPERATOR);
	
	public static double getDriverThrottle()
	{
		return JS_DRIVER.getLeftTrigger() - JS_DRIVER.getRightTrigger();
	}
	
	public static double getDriverTurn()
	{
		return JS_DRIVER.getLeftXAxis();
	}
	
	public static boolean getDriverRearTilt()
	{
		return JS_DRIVER.getButtonA();
	}
	
	public static boolean getDriverFrontTilt()
	{
		return JS_DRIVER.getButtonB();
	}
	
	public static boolean getDriverDoubleTilt()
	{
		return JS_DRIVER.getButtonY();
	}
	
	public static boolean getOperatorShooterSetpointUp()
	{
		return JS_OPERATOR.getButtonRB();
	}
	
	public static boolean getOperatorShooterSetpointDown()
	{
		return JS_OPERATOR.getButtonLB();
	}
	
	public static boolean getOperatorShootShoot()
	{
		return JS_OPERATOR.getButtonA();
	}

}

