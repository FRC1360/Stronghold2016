package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.Subsystems;
import org.usfirst.frc.team1360.robot.util.Subsystems;

/**
 *
 */
public class ShooterCommand extends Command {

    public ShooterCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Subsystems.SHOOTER_ANGLE_SUBSYSTEM);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Subsystems.SHOOTER_ANGLE_SUBSYSTEM.changeShintakePosition(OI.getOperatorShooterSetpointUp() ,OI.getOperatorShooterSetpointDown());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}