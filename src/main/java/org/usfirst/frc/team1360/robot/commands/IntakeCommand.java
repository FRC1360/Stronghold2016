package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

/**
 *
 */
public class IntakeCommand extends Command
{

    private double intake_speed;

    public IntakeCommand(CommandData data)
    {
        requires(Subsystems.INTAKE_SUBSYSTEM);
        intake_speed = data.getDoubles().get("intake_speed");
    }

    public IntakeCommand()
    {

    }

    protected void initialize()
    {

    }

    protected void execute()
    {
        Subsystems.INTAKE_SUBSYSTEM.intakeBoulder(OI.getOperatorIntake());
    }


    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
