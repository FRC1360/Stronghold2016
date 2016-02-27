package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.Subsystems;

/**
 * Shooter Command
 */
public class ShooterCommand extends Command
{
    @Override
    protected void initialize()
    {
        requires(Subsystems.SHOOTER_SUBSYSTEM);
    }

    @Override
    protected void execute()
    {
        if(OI.getOperatorShootShoot())
            Subsystems.SHOOTER_SUBSYSTEM.shoot();
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
}
