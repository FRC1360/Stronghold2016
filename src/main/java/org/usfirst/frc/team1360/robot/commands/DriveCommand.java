package org.usfirst.frc.team1360.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class DriveCommand extends Command
{

    private double drive_throttle;
    private double drive_turn;
    private boolean solenoid_middle;
    private boolean solenoid_back;

    public DriveCommand(CommandData data)
    {
        this.drive_throttle = data.getDoubles().get("drive_throttle");
        this.drive_turn = data.getDoubles().get("drive_turn");
        this.solenoid_back = data.getBooleans().get("drive_sback");
        this.solenoid_middle = data.getBooleans().get("drive_smiddle");
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
