package main.java.org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.org.usfirst.frc.team1360.robot.subsystems.DriveSubsystem;
import main.java.org.usfirst.frc.team1360.robot.util.CommandData;
import main.java.org.usfirst.frc.team1360.robot.util.Subsystems;

public class DriveCommand extends Command
{

    public DriveCommand(CommandData data)
    {

    }

    @Override
    protected void initialize()
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
    }

    @Override
    protected void execute()
    {

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
