package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.PIDHelp;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class PivotCommand extends Command
{
    double m_setpoint;
    public PivotCommand()
    {
        m_setpoint = 300;
        requires(Subsystems.PIVOT_SUBSYSTEM);
    }
    @Override
    protected void initialize()
    {
        Subsystems.PIVOT_SUBSYSTEM.setSetpoint(m_setpoint);
        Subsystems.PIVOT_SUBSYSTEM.enable();
    }

    @Override
    protected void execute()
    {
        PIDHelp.pivotSetpoint();

    }

    @Override
    protected boolean isFinished()
    {
        return Subsystems.PIVOT_SUBSYSTEM.onTarget();
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
