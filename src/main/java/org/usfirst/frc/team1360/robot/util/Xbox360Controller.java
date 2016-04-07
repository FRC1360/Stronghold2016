package org.usfirst.frc.team1360.robot.util;

import edu.wpi.first.wpilibj.Joystick;

public class Xbox360Controller extends Joystick
{

    private double deadzone = 0.15;


    public Xbox360Controller(int port, double deadzone)
    {
        super(port);
        this.deadzone = deadzone;
    }

    /**
     * Left Stick X Axis
     *
     * @return value
     */
    public double getLeftXAxis()
    {
        return deadzone(this.getRawAxis(0));
    }

    /**
     * Left Stick Y Axis
     *
     * @return value
     */
    public double getLeftYAxis()
    {
        return deadzone(this.getRawAxis(1));
    }

    /**
     * Left Trigger
     *
     * @return value
     */
    public double getLeftTrigger()
    {
        return deadzone(this.getRawAxis(2));
    }

    /**
     * Right Trigger
     *
     * @return value
     */
    public double getRightTrigger()
    {
        return deadzone(this.getRawAxis(3));
    }

    /**
     * Right Stick X Axis
     *
     * @return value
     */
    public double getRightXAxis()
    {
        return deadzone(this.getRawAxis(4));
    }

    /**
     * Right Stick Y Axis
     *
     * @return value
     */
    public double getRightYAxis()
    {
        return deadzone(this.getRawAxis(5));
    }

    public boolean getButtonA()
    {
        return this.getRawButton(1);
    }

    public boolean getButtonB()
    {
        return this.getRawButton(2);
    }

    public boolean getButtonX()
    {
        return this.getRawButton(3);
    }

    public boolean getButtonY()
    {
        return this.getRawButton(4);
    }

    public boolean getButtonLB()
    {
        return this.getRawButton(5);
    }

    public boolean getButtonRB()
    {
        return this.getRawButton(6);
    }

    public boolean getButtonBack()
    {
        return this.getRawButton(7);
    }

    public boolean getButtonStart()
    {
        return this.getRawButton(8);
    }

    public boolean getClickLeftStick()
    {
        return this.getRawButton(9);
    }

    public boolean getClickRightStick()
    {
        return this.getRawButton(10);
    }

    private double deadzone(double in, double deadzone)
    {
        return ((Math.abs(in) <= deadzone) ? 0 : in);
    }

    private double deadzone(double in)
    {
        return deadzone(in, this.deadzone);
    }
}
