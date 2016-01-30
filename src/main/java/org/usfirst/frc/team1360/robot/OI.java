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

	private static final Joystick JS_DRIVER = new Joystick(RobotMap.JOYSTICK_DRIVER);
	private static final Joystick JS_OPERATOR = new Joystick(RobotMap.JOYSTICK_OPERATOR);

	private static double getDriverLeftXAxis()
    {
    	return JS_DRIVER.getRawAxis(0); //Driver controller, left stick X axis
    }
    
    private static double getDriverLeftYAxis() //Driver controller, left stick Y axis
    {
    	return JS_DRIVER.getRawAxis(1);
    }
    
    private static double getDriverLeftTrigger() //Driver controller, left trigger
    {
    	return JS_DRIVER.getRawAxis(2);
    }
    
    private static double getDriverRightTrigger() //Driver controller, right trigger
    {
    	return JS_DRIVER.getRawAxis(3);
    }
    
    private static double getDriverRightXAxis() //Driver controller, right stick X axis
    {
    	return JS_DRIVER.getRawAxis(4);
    }
    
    private static double getDriverRightYAxis() //Driver controller, right stick Y axis
    {
    	return JS_DRIVER.getRawAxis(5);
    }
	
    private static boolean getDriverButtonA()
    {
    	return JS_DRIVER.getRawButton(0);
    }
    
    private static boolean getDriverButtonB()
    {
    	return JS_DRIVER.getRawButton(1);
    }
    
    private static boolean getDriverButtonX()
    {
    	return JS_DRIVER.getRawButton(2);
    }
    
    private static boolean getDriverButtonY()
    {
    	return JS_DRIVER.getRawButton(3);
    }
    
    private static boolean getDriverButtonLB()
    {
    	return JS_DRIVER.getRawButton(4);
    }
    
    private static boolean getDriverButtonRB()
    {
    	return JS_DRIVER.getRawButton(5);
    }
    
    private static boolean getDriverButtonBack()
    {
    	return JS_DRIVER.getRawButton(6);
    }
    
    private static boolean getDriverButtonStart()
    {
    	return JS_DRIVER.getRawButton(7);
    }
    
    private static boolean getDriverClickLeftStick()
    {
    	return JS_DRIVER.getRawButton(8);
    }
    
    private static boolean getDriverClickRightStick()
    {
    	return JS_DRIVER.getRawButton(9);
    }
    
    private static double getOperatorLeftStickXAxis()
    {
    	return JS_OPERATOR.getRawAxis(0);
    }
    
    private static double getOperatorLeftStickYAxis()
    {
    	return JS_OPERATOR.getRawAxis(1);
    }
    
    private static double getOperatorLeftTrigger()
    {
    	return JS_OPERATOR.getRawAxis(2);
    }
    
    private static double getOperatorRightTrigger()
    {
    	return JS_OPERATOR.getRawAxis(3);
    }
    
    private static double getOperatorRightStickXAxis()
    {
    	return JS_OPERATOR.getRawAxis(4);
    }
    
    private static double getOperatorRightStickYAxis()
    {
    	return JS_OPERATOR.getRawAxis(5);
    }
    
    private static boolean getOperatorButtonA()
    {
    	return JS_OPERATOR.getRawButton(0);
    }
    
    private static boolean getOperatorButtonB()
    {
    	return JS_OPERATOR.getRawButton(1);
    }
    
    private static boolean getOperatorButtonX()
    {
    	return JS_OPERATOR.getRawButton(2);
    }
    
    private static boolean getOperatorButtonY()
    {
    	return JS_OPERATOR.getRawButton(3);
    }
    
    private static boolean getOperatorButtonLB()
    {
    	return JS_OPERATOR.getRawButton(4);
    }
    
    private static boolean getOperatorButtonRB()
    {
    	return JS_OPERATOR.getRawButton(5);
    }
    
    private static boolean getOperatorButtonBack()
    {
    	return JS_OPERATOR.getRawButton(6);
    }
    
    private static boolean getOperatorButtonStart()
    {
    	return JS_OPERATOR.getRawButton(7);
    }
    
    private static boolean getOperatorClickLeftStick()
    {
    	return JS_OPERATOR.getRawButton(8);
    }
    
    private static boolean getOperatorClickRightStick()
    {
    	return JS_OPERATOR.getRawButton(9);
    }
}

