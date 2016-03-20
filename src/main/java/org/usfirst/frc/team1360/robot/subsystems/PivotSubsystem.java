package org.usfirst.frc.team1360.robot.subsystems;


import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1360.robot.RobotMap;


public class PivotSubsystem extends PIDSubsystem
{
    private Victor pivot = new Victor(RobotMap.PIVOTSUBSYSTEM_TILTER);
    public AnalogInput pot = new AnalogInput(RobotMap.PIVOTSUBSYSTEM_POT);

    public DigitalInput maxSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_UP);
    public DigitalInput minSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_DOWN);

    public PivotSubsystem()
    {
        super("Pivot",0.027,0.000,0.020,0);
        setAbsoluteTolerance(50);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("PivotSubsystem", "PIDSubsystem Controller", getPIDController());
        getPIDController().setInputRange(0, 690);

        enable();



    }

    /**
     * Adder moves the setpoint of the PID based off of it's parameters
     * Increment for example would be a joystick or a trigger
     * While booleans would be their associated buttons such as x and y
     * @param increment
     * @param x
     * @return
     */
    public double adder(double increment,boolean x,boolean y)
    {
        if(y == true){return 600;}
        else if(x == true){return 0;}
        else{return increment+getSetpoint();}
    }
    public double shitSticks()
    {
        return this.getPIDController().get();

    }

    /**
     * Buffers the potentiometer value to read it's around zero in the PID
     * and the driver station
     * @param value
     * @param real
     * @return
     */
    public boolean aboutZero(double value, double real)
    {
        if(value > real - 20 && value < real + 20)
        {
            return true;

        }
        else
        {
            return false;
        }
    }

    public void initDefaultCommand()
    {

    }

    /**
     * returns values from the proxy sensors in a simple 1,-1,0 format for ez implementation.
     * 1 represents you've reached the max value
     * -1 represents the minimum value
     * 0 represents no return from the proxy sensors
     * @return
     */
    public int returnLimit()
    {
        if(!maxSwitch.get()){return 1;}
        if(!minSwitch.get()){return -1;}
        else{return 0;}
    }

    /**
     * real value is fed into the PID and is checked against aboutZero()
     * It takes the potentiometer values and subtracts it by 1220 which is the
     * return from the potentiometer while in the low pivot position
     * it then take the negative reciprocal of that number to make it positive
     * as the potentiometer decreases in value as the pivot goes up
     * @return
     */
    public double realValue()
    {

              if(aboutZero(-(pot.getValue()-1220),0)==true){return 0;}
            else{return -(pot.getValue()-1220);}

    }

    @Override
    protected double returnPIDInput()
    {
        return realValue();
    }

    @Override
    protected void usePIDOutput(double output)
    {
        if(returnLimit() == 1 && output > 0 || returnLimit() == -1 && output < 0) {pivot.set(0);}
        else{pivot.pidWrite(output*0.4);}
    }
}
