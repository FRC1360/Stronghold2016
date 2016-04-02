package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.Subsystems;

/**
 * Intake Command
 */
public class IntakeCommand extends Command
{
    public IntakeCommand()
    {
        requires(Subsystems.INTAKE_SUBSYSTEM);

    }

    protected void initialize()
    {

    }

    protected void execute()
    {
        Subsystems.INTAKE_SUBSYSTEM.intakeBoulder(OI.getOperatorIntake());
        Subsystems.INTAKE_SUBSYSTEM.port(OI.getOperatorPort());
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
