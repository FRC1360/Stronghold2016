package org.usfirst.frc.team1360.robot.util;
import edu.wpi.first.wpilibj.Joystick;

public class Xbox360Controller extends Joystick
{

	public Xbox360Controller(int port) 
	{
		super(port);
	}

    /**
     * Left Stick X Axis
     * @return value
     */
	public double getLeftXAxis()
    {
    	return this.getRawAxis(0);
    }

    /**
     * Left Stick Y Axis
     * @return value
     */
    public double getLeftYAxis()
    {
    	return this.getRawAxis(1);
    }

    /**
     * Left Trigger
     * @return value
     */
    public double getLeftTrigger()
    {
    	return this.getRawAxis(2);
    }

    /**
     * Right Trigger
     * @return value
     */
    public double getRightTrigger()
    {
    	return this.getRawAxis(3);
    }

    /**
     * Right Stick X Axis
     * @return value
     */
    public double getRightXAxis()
    {
    	return this.getRawAxis(4);
    }

    /**
     * Right Stick Y Axis
     * @return value
     */
    public double getRightYAxis()
    {
    	return this.getRawAxis(5);
    }
	
    public boolean getButtonA()
    {
    	return this.getRawButton(0);
    }
    
    public boolean getButtonB()
    {
    	return this.getRawButton(1);
    }
    
    public boolean getButtonX()
    {
    	return this.getRawButton(2);
    }
    
    public boolean getButtonY()
    {
    	return this.getRawButton(3);
    }
    
    public boolean getButtonLB()
    {
    	return this.getRawButton(4);
    }

    public boolean getButtonRB()
    {
    	return this.getRawButton(5);
    }

    public boolean getButtonBack()
    {
    	return this.getRawButton(6);
    }
    
    public boolean getButtonStart()
    {
    	return this.getRawButton(7);
    }
    
    public boolean getClickLeftStick()
    {
    	return this.getRawButton(8);
    }
    
    public boolean getClickRightStick()
    {
    	return this.getRawButton(9);
    }
}
