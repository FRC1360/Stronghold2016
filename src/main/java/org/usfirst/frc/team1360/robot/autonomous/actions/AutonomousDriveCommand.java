package org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.autonomous.IAutoCommand;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.Subsystems;

import java.util.HashMap;

/**
 * Autonomous Drive Command
 */
public class AutonomousDriveCommand extends Command implements IAutoCommand
{
    private double auto_drive_throttle;
    private double auto_drive_turn;
    private double auto_drive_time;
    private Timer initdelay = new Timer();
    private Timer delay = new Timer();
    private CommandData commandData;

    private int i = 0;
    public AutonomousDriveCommand(double auto_drive_throttle, double auto_drive_time, double auto_drive_turn)
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
        this.auto_drive_throttle = auto_drive_throttle;
        this.auto_drive_time = auto_drive_time;
        this.auto_drive_turn = auto_drive_turn;

    }

    public AutonomousDriveCommand(CommandData data)
    {
        requires(Subsystems.DRIVE_SUBSYSTEM);
        commandData = data;
        auto_drive_throttle = data.getDoubles().get("auto_drive_throttle");
        auto_drive_turn = data.getDoubles().get("auto_drive_turn");
        auto_drive_time = data.getDoubles().get("auto_drive_time");
    }

    @Override
    protected void initialize()
    {
        initdelay.reset();
        initdelay.start();
        delay.reset();
        delay.start();
    }

    @Override
    protected void execute()
    {

        i+=1;
        System.out.println(i);
        if(i > 200)
        Subsystems.PIVOT_SUBSYSTEM.setAutoSetpoint(PivotSubsystem.Position.INTAKE);
        if(i > 160) {
            Subsystems.DRIVE_SUBSYSTEM.tankDrive(0.85 * auto_drive_throttle, auto_drive_throttle);
            Subsystems.DRIVE_SUBSYSTEM.changePosition(false);
        }


    }

    @Override
    protected boolean isFinished() {
        return i > 40*auto_drive_time;
    }

    @Override
    protected void end()
    {
        Subsystems.DRIVE_SUBSYSTEM.zeroDrive();
        delay.stop();
    }

    @Override
    protected void interrupted()
    {
        delay.reset();
        delay.stop();
    }

    @Override
    public CommandData getCommandData()
    {
        return commandData;
    }

    @Override
    public HashMap<String, CommandData.DataType> getCommandDataArguments()
    {
        HashMap<String, CommandData.DataType> args = new HashMap<>();
        args.put("auto_drive_throttle", CommandData.DataType.DOUBLE);
        args.put("auto_drive_turn", CommandData.DataType.DOUBLE);
        args.put("auto_drive_time", CommandData.DataType.DOUBLE);
        return args;
    }

    @Override
    public AutonomousDriveCommand newCommandDataInstance(CommandData data)
    {
        return new AutonomousDriveCommand(data);
    }

}
