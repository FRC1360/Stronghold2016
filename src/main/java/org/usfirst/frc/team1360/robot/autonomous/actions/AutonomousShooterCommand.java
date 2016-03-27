package org.usfirst.frc.team1360.robot.autonomous.actions;


import org.usfirst.frc.team1360.robot.autonomous.AutonomousCommand;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

import java.util.HashMap;

public class AutonomousShooterCommand extends AutonomousCommand
{

    public AutonomousShooterCommand()
    {
        requires(Subsystems.SHOOTER_SUBSYSTEM);
    }

    public AutonomousShooterCommand(CommandData data)
    {
        requires(Subsystems.SHOOTER_SUBSYSTEM);
    }

    @Override
    protected void initialize()
    {
    }

    @Override
    protected void execute()
    {
        Subsystems.SHOOTER_SUBSYSTEM.autoShoot(1);
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {

    }

    @Override
    protected void interrupted()
    {

    }
}
