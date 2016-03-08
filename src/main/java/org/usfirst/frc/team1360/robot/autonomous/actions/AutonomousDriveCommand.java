package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

/**
 * Autonomous Drive Command
 */
public class AutonomousDriveCommand extends Command
{
    private double auto_drive_throttle;
    private double auto_drive_turn;
    private double auto_drive_time;
    private Timer delay = new Timer();

    //TODO: NPE Check for variables.
    public AutonomousDriveCommand(CommandData data)
    {
    }

    public AutonomousDriveCommand()
    {

    }

    @Override
    protected void initialize()
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
        delay.reset();
        delay.start();
    }

    @Override
    protected void execute()
    {
        Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(auto_drive_throttle, auto_drive_turn);
    }

    @Override
    protected boolean isFinished()
    {
        return delay.hasPeriodPassed(auto_drive_time);
    }

    @Override
    protected void end()
    {
        delay.stop();
    }

    @Override
    protected void interrupted()
    {
        delay.reset();
        delay.stop();
    }
}
