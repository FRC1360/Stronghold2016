package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.OI;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class ClimbCommand extends Command
{
    public ClimbCommand()
    {
        requires(Subsystems.CLIMBER_SUBSYSTEM);
    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {
        Subsystems.CLIMBER_SUBSYSTEM.scaleTower(OI.getDriverClimbClutch());
        Subsystems.CLIMBER_SUBSYSTEM.deploy(OI.getDriverDeployClimb());
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
