package org.usfirst.frc.team1360.robot.util;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team1360.robot.subsystems.ShooterSubsystem;

public class Subsystems
{
    /**
     * Drive Subsystem
     */
    public static final DriveSubsystem DRIVE_SUBSYSTEM = new DriveSubsystem();
    public static final ShooterSubsystem SHOOTER_SUBSYSTEM = new ShooterSubsystem();
}
