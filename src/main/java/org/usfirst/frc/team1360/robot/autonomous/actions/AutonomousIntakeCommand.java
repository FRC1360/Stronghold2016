package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.autonomous.IAutoCommand;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

import java.util.HashMap;

public class AutonomousIntakeCommand extends Command implements IAutoCommand
{
    private double auto_intake_speed;
    private double auto_intake_time;
    private Timer delay = new Timer();
    private CommandData commandData;

    public AutonomousIntakeCommand(double auto_intake_speed)
    {
        requires(Subsystems.INTAKE_SUBSYSTEM);
        this.auto_intake_speed = auto_intake_speed;
        this.auto_intake_time = auto_intake_time;
    }

    public AutonomousIntakeCommand(CommandData data)
    {
        requires(Subsystems.INTAKE_SUBSYSTEM);
        commandData = data;
        auto_intake_speed = data.getDoubles().get("auto_intake_speed");
    }

    @Override
    protected void initialize()
    {
        delay.reset();
        delay.start();
    }

    @Override
    protected void execute()
    {
        if(delay.get() < auto_intake_time)
            Subsystems.INTAKE_SUBSYSTEM.intakeBoulder(auto_intake_speed);
        else
        {
            Subsystems.INTAKE_SUBSYSTEM.intakeBoulder(0);
            delay.stop();
        }
    }

    @Override
    protected boolean isFinished()
    {
        return delay.hasPeriodPassed(auto_intake_time);
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

    @Override
    public AutonomousIntakeCommand newCommandDataInstance(CommandData data)
    {
        return new AutonomousIntakeCommand(data);
    }
}
