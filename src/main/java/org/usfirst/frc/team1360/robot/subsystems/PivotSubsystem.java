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
    public double adder(double increment)
    {
        return increment+getSetpoint();
    }
    public double shitSticks()
    {
        return this.getPIDController().get();

    }

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
    public int returnLimit()
    {
        if(!maxSwitch.get()){return 1;}
        if(!minSwitch.get()){return -1;}
        else{return 0;}
    }
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
