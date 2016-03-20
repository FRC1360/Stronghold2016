package org.usfirst.frc.team1360.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1360.robot.commands.*;


import org.usfirst.frc.team1360.robot.util.Subsystems;

public class Robot extends IterativeRobot
{
    private static DriveCommand driveCommand;
    private static IntakeCommand intakeCommand;
    private static PivotCommand pivotCommand;
    private static ShooterCommand shooterCommand;
    private static PIDOveridesCommand overideCommand;


//    private Command autonomousCommand;


    public void debug()
    {
       // System.out.println("Shooter RPM encoder: " + Subsystems.SHOOTER_SUBSYSTEM.encoder.getRate());
        //System.out.println("Pivot Down: " + Subsystems.PIVOT_SUBSYSTEM.minSwitch.get());
        //System.out.println("Pivot Up: " + Subsystems.PIVOT_SUBSYSTEM.maxSwitch.get());
        //System.out.println("Real: " + Subsystems.PIVOT_SUBSYSTEM.realValue());
        //System.out.println("POT: "+ Subsystems.PIVOT_SUBSYSTEM.pot.getValue());
        //System.out.println("PID Setpoint: "+ Subsystems.PIVOT_SUBSYSTEM.getSetpoint());
        //System.out.println("On Target: "+Subsystems.PIVOT_SUBSYSTEM.onTarget());

    }

    @Override
    public void robotInit()
    {
        new Subsystems();
        driveCommand = new DriveCommand();
        intakeCommand = new IntakeCommand();
        shooterCommand = new ShooterCommand();
        pivotCommand = new PivotCommand();
        overideCommand = new PIDOveridesCommand();


    }

    @Override
    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit()
    {
        // autonomousCommand = DriverstationDashboard.getAutonomousChoice();
        //autonomousCommand.start();
    }

    private void init()
    {
        pivotCommand.start();
        driveCommand.start();
        shooterCommand.start();
        intakeCommand.start();
        shooterCommand.start();
        overideCommand.start();
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
        //if (autonomousCommand != null) autonomousCommand.cancel();
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
        debug();
        SmartDashboard.putNumber("PID: ",Subsystems.DRIVE_SUBSYSTEM.shitSticks());
        SmartDashboard.putData("PID Controller",Subsystems.PIVOT_SUBSYSTEM.getPIDController());
        SmartDashboard.putData("DriveSubsystem Controller", Subsystems.DRIVE_SUBSYSTEM.getPIDController());

    }

    @Override
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
