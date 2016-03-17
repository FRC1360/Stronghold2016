package org.usfirst.frc.team1360.robot.subsystems;


import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1360.robot.RobotMap;


public class PivotSubsystem extends PIDSubsystem
{
    private Victor pivot = new Victor(RobotMap.PIVOTSUBSYSTEM_TILTER);
    public AnalogPotentiometer pot = new AnalogPotentiometer(RobotMap.PIVOTSUBSYSTEM_POT,1220);

    public DigitalInput maxSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_UP);
    public DigitalInput minSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_DOWN);

    public PivotSubsystem()
    {

        super("PivotSubsystem", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(5.0);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("PivotSubsystem", "PIDSubsystem Controller", getPIDController());
        getPIDController().setInputRange(0, 754);

    }

    public boolean aboutZero(double value, int real)
    {
        if(value > real - 5 && value < real + 5)
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

        return -(pot.get()-1220);
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
        else{pivot.pidWrite(output*0.25);}
    }
}
