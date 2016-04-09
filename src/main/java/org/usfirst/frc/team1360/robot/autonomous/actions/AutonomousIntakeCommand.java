package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team1360.robot.autonomous.AutonomousCommand;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class AutonomousIntakeCommand extends AutonomousCommand
{
    private double auto_intake_speed;
    private double auto_intake_time;
    private Timer delay = new Timer();

    public AutonomousIntakeCommand(double auto_intake_speed, double auto_intake_time)
    {
        requires(Subsystems.INTAKE_SUBSYSTEM);
        this.auto_intake_speed = auto_intake_speed;
        this.auto_intake_time = auto_intake_time;
    }

    public AutonomousIntakeCommand(CommandData data)
    {
        requires(Subsystems.INTAKE_SUBSYSTEM);
        auto_intake_speed = data.getDoubles().get("auto_intake_speed");
        auto_intake_time = data.getDoubles().get("auto_intake_time");
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
}
