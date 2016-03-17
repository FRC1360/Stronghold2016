package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class PivotCommand extends Command
{
    double m_setpoint;
    public PivotCommand()
    {
        //m_setpoint = setpoint;
        requires(Subsystems.PIVOT_SUBSYSTEM);
    }
    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Subsystems.PIVOT_SUBSYSTEM.enable();
        //Subsystems.PIVOT_SUBSYSTEM.setSetpoint(m_setpoint);
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
