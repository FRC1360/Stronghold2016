package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.autonomous.IAutoCommand;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

import java.util.HashMap;

public class AutonomousShooterCommand extends Command implements IAutoCommand
{
    private double time;
    private double speed;
    private Timer delay = new Timer();
    public AutonomousShooterCommand(double speed, double time)
    {
        requires(Subsystems.SHOOTER_SUBSYSTEM);
        this.time = time;
        this.speed = speed;

    }

    public AutonomousShooterCommand(CommandData data)
    {

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
        Subsystems.SHOOTER_SUBSYSTEM.autoShoot(1);
    }

    @Override
    protected boolean isFinished()
    {
        return delay.hasPeriodPassed(time);
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
