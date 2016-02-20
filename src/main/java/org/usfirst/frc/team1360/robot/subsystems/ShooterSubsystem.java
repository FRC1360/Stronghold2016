package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.RobotMap;

/**
 * TODO: Needs to be properly done with PID. Currently just a hackey workaround.
 */
public class ShooterSubsystem extends Subsystem
{

    /**
     * Shooter motor
     */
    Victor SHOOTER_1 = new Victor(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_1);

    /**
     * Shooter solenoid
     */
    Solenoid SHOOT_SOLENOID = new Solenoid(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_SOLENOID);


    public void shoot(boolean pressed, double speed)
    {
        SHOOTER_1.set(speed);
        SHOOT_SOLENOID.set(pressed);
    }

    public void initDefaultCommand()
    {

    }
}

