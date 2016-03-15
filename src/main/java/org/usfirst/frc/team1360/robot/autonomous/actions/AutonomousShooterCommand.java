package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.autonomous.IAutoCommand;
import org.usfirst.frc.team1360.robot.util.CommandData;

import java.util.HashMap;

public class AutonomousShooterCommand extends Command implements IAutoCommand
{
    private double time;
    private double speed;

    public AutonomousShooterCommand()
    {

    }

    public AutonomousShooterCommand(CommandData data)
    {

    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {

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
    public AutonomousShooterCommand newCommandDataInstance(CommandData data)
    {
        return new AutonomousShooterCommand(data);
    }
}
