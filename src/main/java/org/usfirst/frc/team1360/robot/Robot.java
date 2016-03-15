package org.usfirst.frc.team1360.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1360.robot.commands.DriveCommand;
import org.usfirst.frc.team1360.robot.commands.IntakeCommand;
import org.usfirst.frc.team1360.robot.commands.PivotCommand;
import org.usfirst.frc.team1360.robot.commands.ShooterCommand;
import org.usfirst.frc.team1360.robot.util.DriverstationDashboard;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class Robot extends IterativeRobot
{
    private static DriveCommand driveCommand;
    private static IntakeCommand intakeCommand;
    private static PivotCommand pivotCommand;
    private static ShooterCommand shooterCommand;

    private Command autonomousCommand;


    public void debug()
    {
        System.out.println("Shooter RPM encoder: " + Subsystems.SHOOTER_SUBSYSTEM.encoder.get());
        System.out.println("Pivot Down: " + Subsystems.PIVOT_SUBSYSTEM.minSwitch.get());
        System.out.println("Pivot Up: " + Subsystems.PIVOT_SUBSYSTEM.maxSwitch.get());
        System.out.println("Pivot Poten: " + Subsystems.PIVOT_SUBSYSTEM.pot.getValue());
    }

    @Override
    public void robotInit()
    {
        new Subsystems();
        driveCommand= new DriveCommand();
        intakeCommand = new IntakeCommand();
        shooterCommand = new ShooterCommand();
        pivotCommand = new PivotCommand();

        DriverstationDashboard.init();
    }

    @Override
    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit()
    {
        autonomousCommand = DriverstationDashboard.getAutonomousChoice();
        autonomousCommand.start();
    }

    private void init()
    {
        pivotCommand.start();
        driveCommand.start();
        shooterCommand.start();
        intakeCommand.start();
        shooterCommand.start();
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
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        init();

    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit()
    {

    }
    @Override
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
        debug();
    }

    @Override
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
