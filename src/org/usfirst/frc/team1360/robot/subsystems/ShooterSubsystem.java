package org.usfirst.frc.team1360.robot.subsystems;

import org.usfirst.frc.team1360.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterSubsystem extends Subsystem {
    
	/**
	 * Shooter motor
	 */
    Victor SHOOTER_1 = new Victor(RobotMap.SHOOTER_MOTOR);

    /**
     * sets the motor speed
     * @param speed for the motor
     */
    public void setShooterSpeed(double speed)
    {
    	if(Math.abs(speed) < 0.1) speed = 0;
    	SHOOTER_1.set(speed);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

