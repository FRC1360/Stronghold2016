package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class DriveCommand extends Command
{
    public DriveCommand()
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Subsystems.DRIVE_SUBSYSTEM.setSetpoint(OI.getDriverThrottle());
        Subsystems.DRIVE_SUBSYSTEM.changePosition(OI.getDriverRearTilt());
        Subsystems.DRIVE_SUBSYSTEM.arcadeDrive(OI.getDriverTurn(), OI.getDriverThrottle());
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
