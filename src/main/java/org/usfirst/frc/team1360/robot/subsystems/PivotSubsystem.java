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
    private AnalogInput pot = new AnalogInput(RobotMap.PIVOTSUBSYSTEM_POT);

    private DigitalInput maxSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_UP);
    private DigitalInput minSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_DOWN);
    private boolean REDBUTTON = false;
    private double zeroValue = -196;
    private double potResolution = 705;

    public PivotSubsystem()
    {
        super("Pivot", 0.010, 0.000, 0.020, 0);
        setAbsoluteTolerance(50);
        setSetpoint(realValue());
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("PivotSubsystem", "PIDSubsystem Controller", getPIDController());
        getPIDController().setInputRange(0, potResolution);
        enable();
    }

    /**returns potentiometer values
     *
     * @return
     */
    public double returnPot(){return pot.getValue();}
    public double shitSticks()
    {
        return this.getPIDController().get();
    }

    /**
     * Overrides PID if potentiometer slips, and proxy sensors are unable to correct
     * for new values
     * @param start
     * @return
     */
    public boolean override(boolean start)
    {

        if(start)
        {
            REDBUTTON = true;
        }
        return REDBUTTON;
    }
    /**
     * Adder moves the setpoint of the PID based off of it's parameters
     * Increment for example would be a joystick or a trigger
     * While booleans would be their associated buttons such as x and y
     *
     * @param increment a
     * @param x         a
     *                  @param y t
     * @return add
     */
    public double adder(double increment, boolean x, boolean y)
    {
        if (x) return 655;
        else if (y) return 0;
        else return increment + getSetpoint();
    }

    /**
     * Sets a setpoint in autonomous
     * @param position
     */
    public void setAutoSetpoint(Position position)
    {
        setSetpoint(position.getSetpoint());
    }

    /**
     * Buffers the potentiometer value to read it's around zero in the PID
     * and the driver station
     *
     * @param value v
     * @param real  r
     * @return is it
     */
    private boolean aboutZero(double value, double real)
    {
        return value > real - 10 && value < real + 10;
    }

    /**
     * Manual mode for last resort if inputted PID values are unable to correct
     * in the event of potentiometer slip
      * @param speed
     */
    public void manual(double speed)
    {
        if(REDBUTTON)
        {
            pivot.set(speed*0.30);
            System.out.println("PID OVERRIDED");
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
     *
     * @return l
     */
    private int returnLimit()
    {
        return ((!maxSwitch.get() ? 1 : (!minSwitch.get() ? -1 : 0)));
    }

    /**
     * corrects for potentiometer slips
     */
    private void correctZero()
    {
        if(returnLimit() == 1){zeroValue = (returnPot() - potResolution);}
        else if (returnLimit() == -1){zeroValue = returnPot();}
    }

    /**
     * real value is fed into the PID and is checked against aboutZero()
     * It takes the potentiometer values and subtracts it by 1220 which is the
     * return from the potentiometer while in the low pivot position
     * it then take the negative reciprocal of that number to make it positive
     * as the potentiometer decreases in value as the pivot goes up
     *
     * @return v
     */
    private double realValue()
    {

        correctZero();
        return (aboutZero(-(returnPot() -zeroValue ), 0) ? 0 : -(returnPot() - zeroValue));
    }


    @Override
    protected double returnPIDInput()
    {
        return realValue();
    }

    @Override
    protected void usePIDOutput(double output)
    {

        if (returnLimit() == 1 && output > 0 || returnLimit() == -1 && output < 0) //if hitting any proxy sensors set value to 0
        {
            pivot.set(0);
        }
        else if(!REDBUTTON) //if override is false then use PID
        {
            pivot.pidWrite(output * 0.45);

        }
        //System.out.println("POT: "+returnPot());
        //System.out.println("REAL: "+realValue());

    }

    public enum Position
    {
        //TODO: Set these numbers to be actual.
        TOP(710), SHOOT(655), INTAKE(0);

        private double psetpoint;
        Position(double csetpoint)
        {
            psetpoint = csetpoint;
        }

        double getSetpoint()
        {
            return psetpoint;
        }
    }
}
