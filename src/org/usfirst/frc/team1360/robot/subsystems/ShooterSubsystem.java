package org.usfirst.frc.team1360.robot.subsystems;

import org.usfirst.frc.team1360.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
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
     * Shooter encoder
     */
    Encoder SHOOTER_ENCODER = new Encoder(RobotMap.SHOOTER_ENCODER_CH1, RobotMap.SHOOTER_ENCODER_CH2, true, Encoder.EncodingType.k4X);

    boolean isMoving = false;
    int targetPos = 0;
    
    /**
     * sets the motor speed
     * @param speed for the motor
     */
    public void setShooterSpeed(double speed)
    {
    	if(Math.abs(speed) < 0.1) speed = 0;
    	SHOOTER_1.set(speed);
    }
    
    /**
     * Changes the shintake position based on two presets
     * @param Joystick from the operator that changes the shintake position
     */
    public void changeShintakePosition(double Joystick)
    {
    	if(!isMoving)
    	{
    		if(Joystick > 0.9)
    		{
    			SHOOTER_1.set(10);
    			targetPos = 500;
    		}
    		if(Joystick < -0.9)
    		{
    			SHOOTER_1.set(-10);
    			targetPos = 0;
    		}
    	}
    	else
    	{
    		if(SHOOTER_ENCODER.get() > targetPos - 5 && SHOOTER_ENCODER.get() < targetPos + 5)
    		{
    			SHOOTER_1.set(0);
    		}
    	}
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

