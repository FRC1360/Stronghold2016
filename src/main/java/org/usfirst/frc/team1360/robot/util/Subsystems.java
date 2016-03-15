package org.usfirst.frc.team1360.robot.util;

import org.usfirst.frc.team1360.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1360.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.subsystems.ShooterSubsystem;


public class Subsystems
{
    public static DriveSubsystem DRIVE_SUBSYSTEM;
    public static ShooterSubsystem SHOOTER_SUBSYSTEM;
    public static IntakeSubsystem INTAKE_SUBSYSTEM;
    public static PivotSubsystem PIVOT_SUBSYSTEM;

    public Subsystems()
    {
        PIVOT_SUBSYSTEM = new PivotSubsystem();
        INTAKE_SUBSYSTEM = new IntakeSubsystem();
        SHOOTER_SUBSYSTEM = new ShooterSubsystem();
        DRIVE_SUBSYSTEM = new DriveSubsystem();
    }
}
