package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team1360.robot.autonomous.AutonomousCommand;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

/**
 * Autonomous Drive Command
 */
public class AutonomousDriveCommand extends AutonomousCommand
{
    private double auto_drive_throttle;
    private double auto_drive_turn;
    private double auto_drive_time;
    private boolean auto_drive_actuated;

    private int i = 0;

    public AutonomousDriveCommand(double auto_drive_throttle, double auto_drive_time, double auto_drive_turn, boolean auto_drive_actuated)
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);

        this.auto_drive_actuated = auto_drive_actuated;
        this.auto_drive_throttle = auto_drive_throttle;
        this.auto_drive_time = auto_drive_time;
        this.auto_drive_turn = auto_drive_turn;

    }

    public AutonomousDriveCommand(CommandData data)
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
        auto_drive_throttle = data.getDoubles().get("auto_drive_throttle");
        auto_drive_turn = data.getDoubles().get("auto_drive_turn");
        auto_drive_time = data.getDoubles().get("auto_drive_time");
        auto_drive_actuated = data.getBooleans().get("auto_drive_actuated");
    }

    @Override
    protected void initialize()
    {
        i = 0;
    }

    @Override
    protected void execute()
    {
        i += 1;
        Subsystems.DRIVE_SUBSYSTEM.tankDrive(0.9*auto_drive_throttle, auto_drive_throttle);
        Subsystems.DRIVE_SUBSYSTEM.changePosition(auto_drive_actuated);

    }

    @Override
    protected boolean isFinished()
    {
        return i >= 40 * auto_drive_time;
    }

    @Override
    protected void end()
    {
        Subsystems.DRIVE_SUBSYSTEM.zeroDrive();
        i = 0;
    }

    @Override
    protected void interrupted()
    {
    }
}
