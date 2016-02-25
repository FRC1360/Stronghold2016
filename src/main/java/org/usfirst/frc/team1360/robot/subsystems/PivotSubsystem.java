package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import org.usfirst.frc.team1360.robot.RobotMap;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Victor;



public class PivotSubsystem extends PIDSubsystem
{

    Victor pivot = new Victor(RobotMap.PIVOTSUBSYSTEM_TILTER);
    AnalogInput pot = new AnalogInput(RobotMap.PIVOTSUBSYSTEM_POT);
    static double setpoint = 0;

    public PivotSubsystem(boolean b1, boolean b2)
    {
        super("Pivot",2.0,0.01,0.001);
        setAbsoluteTolerance(0.05);
        getPIDController().setContinuous(false);
        getPIDController().setSetpoint(returnSetpoint(b1,b2));


    }
    public double returnSetpoint(boolean button1, boolean button2)
    {

        if(button1 == true && setpoint < 5.0) {setpoint = setpoint + 2.5;}
        else if(button2  == true && setpoint > 0){setpoint = setpoint - 2.5;}
        return setpoint;

    }

    public void initDefaultCommand()
    {

    }


    public double returnPIDInput()
    {
        return pot.getAverageVoltage();
    }
    protected void usePIDOutput(double output)
    {
        pivot.pidWrite(output);
    }
}
