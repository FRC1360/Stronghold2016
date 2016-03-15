package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.Robot;
import org.usfirst.frc.team1360.robot.RobotMap;


public class PivotSubsystem extends PIDSubsystem
{
    private double setpoint = 466;
    private Victor pivot = new Victor(RobotMap.PIVOTSUBSYSTEM_TILTER);
    public AnalogInput pot = new AnalogInput(RobotMap.PIVOTSUBSYSTEM_POT);

    public DigitalInput maxSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_UP);
    public DigitalInput minSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_DOWN);

    public final static double BOTTOM = 0,MID = 377,TOP = 754;

    public double value;
    public int current = 0;

    public PivotSubsystem(boolean a,boolean y)
    {
        super("Pivot",2.0,0.1,0.001);
        getPIDController().setContinuous(false);
        setSetpoint(currentSetpoint(a,y));

    }
    public double currentSetpoint(boolean a,boolean y)
    {
        if (a == true && current > 0){current--;}
        else if(y == true && current < 2){current++;}
        if(current == 2){return TOP;}
        else if(current == 1){return MID;}
        else {return BOTTOM;}
    }
    public boolean aboutZero(double value, int real)
    {
        if(value > real - 5 && value < real + 5){return true;}
        else {return false;}
    }
    public double returnRealPOT()
    {
         value = (pot.getValue() - 1220)/-1;

        if(aboutZero(value,0) == true){return 0;}
        else{return value;}

    }
    public void initDefaultCommand()
    {

    }
    public int returnLimit()
    {
        if(maxSwitch.get() == false){return 1;}
        if(minSwitch.get() == false){return -1;}
        else{return 0;}
    }
    public void setPivot(double speed)
    {
        usePIDOutput(speed);
        if(returnLimit() == 1 && speed > 0 || returnLimit() == -1 && speed < 0) {pivot.set(0);}
        else{pivot.set(speed);}
    }

    @Override
    protected double returnPIDInput()
    {
        return returnRealPOT();
    }

    @Override
    protected void usePIDOutput(double speed)
    {

    }
}
