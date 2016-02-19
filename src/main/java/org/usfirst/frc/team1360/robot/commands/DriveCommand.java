package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class DriveCommand extends Command
{

    private double drive_throttle;
    private double drive_turn;
    private boolean solenoid_back;

    public DriveCommand()
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
    }

    @Override
    protected void initialize()
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
    }

    @Override
    protected void execute()
    {
        Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(OI.getDriverThrottle(), OI.getDriverTurn());
        Subsystems.DRIVE_SUBSYSTEM.changePosition(OI.getDriverRearTilt());
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
