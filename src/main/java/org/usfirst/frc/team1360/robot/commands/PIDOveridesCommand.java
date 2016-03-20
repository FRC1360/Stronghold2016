package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.PIDOveride;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class PIDOveridesCommand extends Command
{
    public PIDOveridesCommand()
    {
        requires(Subsystems.PIVOT_SUBSYSTEM);
        requires(Subsystems.DRIVE_SUBSYSTEM);
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        PIDOveride.pivotOveride(OI.getOveridePivot());
        PIDOveride.driveOveride(OI.getOverideDrive());
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
