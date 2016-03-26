package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.autonomous.IAutoCommand;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

import java.util.HashMap;

public class AutonomousPivotCommand extends Command implements IAutoCommand
{
    private PivotSubsystem.Position position;

    public AutonomousPivotCommand(CommandData data)
    {
        requires(Subsystems.PIVOT_SUBSYSTEM);
        position = PivotSubsystem.Position.valueOf(data.getStrings().get("auto_pivot_position"));
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

    @Override
    public CommandData getCommandData()
    {
        return null;
    }

    @Override
    public HashMap<String, CommandData.DataType> getCommandDataArguments()
    {
        return null;
    }

    @Override
    public AutonomousPivotCommand newCommandDataInstance(CommandData data)
    {
        return new AutonomousPivotCommand(data);
    }
}
