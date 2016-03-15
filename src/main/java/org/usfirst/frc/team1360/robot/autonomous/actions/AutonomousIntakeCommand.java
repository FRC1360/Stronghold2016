package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.autonomous.IAutoCommand;
import org.usfirst.frc.team1360.robot.util.CommandData;

import java.util.HashMap;

public class AutonomousIntakeCommand extends Command implements IAutoCommand
{
    private double auto_intake_speed;
    private CommandData commandData;
    public AutonomousIntakeCommand()
    {

    }

    public AutonomousIntakeCommand(CommandData data)
    {
        commandData = data;
        data.getDoubles().get("auto_intake_speed");
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
        return commandData;
    }

    @Override
    public HashMap<String, CommandData.DataType> getCommandDataArguments()
    {
        HashMap<String, CommandData.DataType> output = new HashMap<>();
        output.put("auto_intake_speed", CommandData.DataType.DOUBLE);
        return output;
    }
}
