package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.Robot;
import org.usfirst.frc.team1360.robot.RobotMap;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class ClimberSubsystem extends Subsystem
{
    private Solenoid safety = new Solenoid(RobotMap.CLIMBERSUBSYSTEM_CLIMBER_ENABLE);
    private Solenoid useDrive = new Solenoid(RobotMap.CLIMBERSUBSYSTEM_CLIMBER_DRIVE);

    public ClimberSubsystem()
    {

    }

    @Override
    protected void initDefaultCommand()
    {

    }

    public void scaleTower(boolean toggle)
    {
        useDrive.set(toggle);
    }

    public void deploy(boolean toggle)
    {
        safety.set(toggle);
    }
}
