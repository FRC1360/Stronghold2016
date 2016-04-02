package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;

import org.usfirst.frc.team1360.robot.util.Subsystems;

public class PivotCommand extends Command
{
    public PivotCommand()
    {
        requires(Subsystems.PIVOT_SUBSYSTEM);
    }
    @Override
    protected void initialize()
    {


    }

    @Override
    protected void execute()
    {

        Subsystems.PIVOT_SUBSYSTEM.setSetpoint(Subsystems.PIVOT_SUBSYSTEM.adder(OI.getOperatorPivot(),
                OI.getOperatorPivotSetpointUp(),
                OI.getOperatorPivotSetpointDown()));
        Subsystems.PIVOT_SUBSYSTEM.override(OI.BIGREDBUTTON());
        Subsystems.PIVOT_SUBSYSTEM.manual(OI.getOperatorPivot()*0.45);

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
