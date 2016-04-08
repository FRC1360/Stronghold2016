package org.usfirst.frc.team1360.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1360.robot.autonomous.groups.AutonomousBreachGroup;
import org.usfirst.frc.team1360.robot.commands.*;


import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.CommandData;
import org.usfirst.frc.team1360.robot.util.DriverstationDashboard;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class Robot extends IterativeRobot
{
    private static DriveCommand driveCommand;
    private static IntakeCommand intakeCommand;
    private static PivotCommand pivotCommand;
    private static ShooterCommand shooterCommand;
    private DriverstationDashboard ds;

    private Command autonomousCommand;

    private void init()
    {
	pivotCommand.start();
	driveCommand.start();
	shooterCommand.start();
	intakeCommand.start();
	shooterCommand.start();
    }

    private CommandData autoData()
    {
	CommandData data = new CommandData();
	data.addDouble("auto_drive_throttle",
		(ds.getAutoDirection() == AutonomousBreachGroup.Direction.FORWARDS ? -1 : 1) * 1D);
	data.addDouble("auto_drive_turn", 0);
	data.addDouble("auto_drive_time", 7);
	data.addBoolean("auto_drive_actuated", true);

	data.addObject("auto_pivot_position", PivotSubsystem.Position.TOP);
	return data;
    }

    @Override
    public void robotInit()
    {
	new Subsystems();
	ds = new DriverstationDashboard(autoData());
	driveCommand = new DriveCommand();
	intakeCommand = new IntakeCommand();
	shooterCommand = new ShooterCommand();
	pivotCommand = new PivotCommand();

	ds.initAutoSelection();
    }

    @Override
    public void disabledPeriodic()
    {
	Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit()
    {
	autonomousCommand = ds.getAutoSelection();
	autonomousCommand.start();
    }


    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
	Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
	if (autonomousCommand != null) autonomousCommand.cancel();
	init();
    }

    @Override
    public void disabledInit()
    {

    }

    @Override
    public void teleopPeriodic()
    {
	Scheduler.getInstance().run();
	SmartDashboard.putNumber("PID: ",Subsystems.PIVOT_SUBSYSTEM.shitSticks());
	SmartDashboard.putData("PivotSubsystem Controller", Subsystems.PIVOT_SUBSYSTEM.getPIDController());

    }

    @Override
    public void testPeriodic()
    {
	LiveWindow.run();
    }
}
