package main.java.org.usfirst.frc.team1360.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{

	public static final Joystick JS_DRIVER = new Joystick(RobotMap.JOYSTICK_DRIVER);
	public static final Joystick JS_OPERATOR = new Joystick(RobotMap.JOYSTICK_OPERATOR);

	public static double getDriverLeftXAxis()
    {
    	return JS_DRIVER.getRawAxis(0); //Driver controller, left stick X axis
    }
    
    public static double getDriverLeftYAxis() //Driver controller, left stick Y axis
    {
    	return JS_DRIVER.getRawAxis(1);
    }
    
    public static double getDriverLeftTrigger() //Driver controller, left trigger
    {
    	return JS_DRIVER.getRawAxis(2);
    }
    
    public static double getDriverRightTrigger() //Driver controller, right trigger
    {
    	return JS_DRIVER.getRawAxis(3);
    }
    
    public static double getDriverRightXAxis() //Driver controller, right stick X axis
    {
    	return JS_DRIVER.getRawAxis(4);
    }
    
    public static double getDriverRightYAxis() //Driver controller, right stick Y axis
    {
    	return JS_DRIVER.getRawAxis(5);
    }
	
    public static boolean getDriverButtonA()
    {
    	return JS_DRIVER.getRawButton(0);
    }
    
    public static boolean getDriverButtonB()
    {
    	return JS_DRIVER.getRawButton(1);
    }
    
    public static boolean getDriverButtonX()
    {
    	return JS_DRIVER.getRawButton(2);
    }
    
    public static boolean getDriverButtonY()
    {
    	return JS_DRIVER.getRawButton(3);
    }
    
    public static boolean getDriverButtonLB()
    {
    	return JS_DRIVER.getRawButton(4);
    }
    
    public static boolean getDriverButtonRB()
    {
    	return JS_DRIVER.getRawButton(5);
    }
    
    public static boolean getDriverButtonBack()
    {
    	return JS_DRIVER.getRawButton(6);
    }
    
    public static boolean getDriverButtonStart()
    {
    	return JS_DRIVER.getRawButton(7);
    }
    
    public static boolean getDriverClickLeftStick()
    {
    	return JS_DRIVER.getRawButton(8);
    }
    
    public static boolean getDriverClickRightStick()
    {
    	return JS_DRIVER.getRawButton(9);
    }
    
    public static double getOperatorLeftStickXAxis()
    {
    	return JS_OPERATOR.getRawAxis(0);
    }
    
    public static double getOperatorLeftStickYAxis()
    {
    	return JS_OPERATOR.getRawAxis(1);
    }
    
    public static double getOperatorLeftTrigger()
    {
    	return JS_OPERATOR.getRawAxis(2);
    }
    
    public static double getOperatorRightTrigger()
    {
    	return JS_OPERATOR.getRawAxis(3);
    }
    
    public static double getOperatorRightStickXAxis()
    {
    	return JS_OPERATOR.getRawAxis(4);
    }
    
    public static double getOperatorRightStickYAxis()
    {
    	return JS_OPERATOR.getRawAxis(5);
    }
    
    public static boolean getOperatorButtonA()
    {
    	return JS_OPERATOR.getRawButton(0);
    }
    
    public static boolean getOperatorButtonB()
    {
    	return JS_OPERATOR.getRawButton(1);
    }
    
    public static boolean getOperatorButtonX()
    {
    	return JS_OPERATOR.getRawButton(2);
    }
    
    public static boolean getOperatorButtonY()
    {
    	return JS_OPERATOR.getRawButton(3);
    }
    
    public static boolean getOperatorButtonLB()
    {
    	return JS_OPERATOR.getRawButton(4);
    }
    
    public static boolean getOperatorButtonRB()
    {
    	return JS_OPERATOR.getRawButton(5);
    }
    
    public static boolean getOperatorButtonBack()
    {
    	return JS_OPERATOR.getRawButton(6);
    }
    
    public static boolean getOperatorButtonStart()
    {
    	return JS_OPERATOR.getRawButton(7);
    }
    
    public static boolean getOperatorClickLeftStick()
    {
    	return JS_OPERATOR.getRawButton(8);
    }
    
    public static boolean getOperatorClickRightStick()
    {
    	return JS_OPERATOR.getRawButton(9);
    }
}

