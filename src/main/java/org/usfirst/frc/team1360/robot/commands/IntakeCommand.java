package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;
import org.usfirst.frc.team1360.robot.OI;

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

    protected void initialize()
    {

    }

    protected void execute()
    {
    	Subsystems.INTAKE_SUBSYSTEM.intakeBoulder(intake_speed);
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
