package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.RobotMap;


public class PivotSubsystem extends Subsystem
{
    private double setpoint = 0;
    private Victor pivot = new Victor(RobotMap.PIVOTSUBSYSTEM_TILTER);
    private AnalogInput pot = new AnalogInput(RobotMap.PIVOTSUBSYSTEM_POT);



    public void initDefaultCommand()
    {

    }

    public void setPivot(double speed)
    {
        pivot.set(speed);
    }
}
