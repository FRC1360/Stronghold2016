package main.java.org.usfirst.frc.team1360.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import main.java.org.usfirst.frc.team1360.robot.util.Xbox360Controller;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{

	private static final Xbox360Controller JS_DRIVER = new Xbox360Controller(RobotMap.JOYSTICK_DRIVER);
	private static final Xbox360Controller JS_OPERATOR = new Xbox360Controller(RobotMap.JOYSTICK_OPERATOR);
	
	public static double getDriverThrottle()
	{
		return 0;
	}

}

