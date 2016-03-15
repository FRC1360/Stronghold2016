package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.Robot;
import org.usfirst.frc.team1360.robot.RobotMap;


public class PivotSubsystem extends Subsystem
{
    private double setpoint = 0;
    private Victor pivot = new Victor(RobotMap.PIVOTSUBSYSTEM_TILTER);
    public AnalogInput pot = new AnalogInput(RobotMap.PIVOTSUBSYSTEM_POT);

    public DigitalInput maxSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_UP);
    public DigitalInput minSwitch = new DigitalInput(RobotMap.SHOOTERSUBSYSTEM_SWITCH_DOWN);


    public void initDefaultCommand()
    {

    }

    public void setPivot(double speed)
    {
        pivot.set(speed);
    }
}
