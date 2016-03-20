package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.Subsystems;

/**
 * Shooter Command
 */
public class ShooterCommand extends Command
{
    private double setpoint;

    public ShooterCommand()
    {
        requires(Subsystems.SHOOTER_SUBSYSTEM);
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Subsystems.SHOOTER_SUBSYSTEM.shoot(OI.getOperatorFire());
        Subsystems.SHOOTER_SUBSYSTEM.shooterRPM(OI.getOperatorShooterRPM());

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
