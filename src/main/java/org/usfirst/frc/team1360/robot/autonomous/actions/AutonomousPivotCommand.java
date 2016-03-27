package org.usfirst.frc.team1360.robot.autonomous.actions;

import org.usfirst.frc.team1360.robot.autonomous.AutonomousCommand;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class AutonomousPivotCommand extends AutonomousCommand
{
    private PivotSubsystem.Position position;

    public AutonomousPivotCommand(CommandData data)
    {
        requires(Subsystems.PIVOT_SUBSYSTEM);
        position = (PivotSubsystem.Position) data.getObjects().get("auto_pivot_position");
    }

    public AutonomousPivotCommand(PivotSubsystem.Position position)
    {
        requires(Subsystems.PIVOT_SUBSYSTEM);
        this.position = position;
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Subsystems.PIVOT_SUBSYSTEM.setAutoSetpoint(position);
    }

    @Override
    protected boolean isFinished()
    {
        return true;
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
