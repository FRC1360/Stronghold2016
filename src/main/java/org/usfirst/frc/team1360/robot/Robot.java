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
import org.usfirst.frc.team1360.robot.util.PIDHelp;
import org.usfirst.frc.team1360.robot.util.Subsystems;

public class Robot extends IterativeRobot
{
    private static DriveCommand driveCommand;
    private static IntakeCommand intakeCommand;
    private static PivotCommand pivotCommand;
    private static ShooterCommand shooterCommand;

//    private Command autonomousCommand;


    public void debug()
    {
        System.out.println("Shooter RPM encoder: " + Subsystems.SHOOTER_SUBSYSTEM.encoder.get());
        System.out.println("Pivot Down: " + Subsystems.PIVOT_SUBSYSTEM.minSwitch.get());
        System.out.println("Pivot Up: " + Subsystems.PIVOT_SUBSYSTEM.maxSwitch.get());
        System.out.println("Pivot Poten: " + Subsystems.PIVOT_SUBSYSTEM.pot.get());
        System.out.println("Setpoint: " + PIDHelp.pivotSetpoint());
    }

    @Override
    public void robotInit()
    {
        new Subsystems();
        driveCommand= new DriveCommand();
        intakeCommand = new IntakeCommand();
        shooterCommand = new ShooterCommand();
        pivotCommand = new PivotCommand(PIDHelp.pivotSetpoint());

        //DriverstationDashboard.init();
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
    }

    @Override
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}
