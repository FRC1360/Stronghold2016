package org.usfirst.frc.team1360.robot.util;

import org.usfirst.frc.team1360.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1360.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.subsystems.ShooterSubsystem;


public class Subsystems
{
    public static final DriveSubsystem DRIVE_SUBSYSTEM = new DriveSubsystem();
    public static final ShooterSubsystem SHOOTER_SUBSYSTEM = new ShooterSubsystem();
    public static final IntakeSubsystem INTAKE_SUBSYSTEM = new IntakeSubsystem();
    public static final PivotSubsystem PIVOT_SUBSYSTEM = new PivotSubsystem();
}