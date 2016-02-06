package org.usfirst.frc.team1360.robot.subsystems;

import org.usfirst.frc.team1360.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ShooterAngleSubsystem extends Subsystem {
    
	/**
	 * Shooter motor
	 */
    Victor SHOOTER_1 = new Victor(RobotMap.SHOOTER_MOTOR);
    /**
     * Shooter encoder
     */
    Encoder SHOOTER_ENCODER = new Encoder(RobotMap.SHOOTER_ENCODER_CH1, RobotMap.SHOOTER_ENCODER_CH2, true, Encoder.EncodingType.k4X);

    int targetPos = 0;
    // 0 = bottom
    // 1 = moving up
    // 2 = moving down
    // 3 = top
    int ShootPos = 0;
    
    /**
     * Changes the shooter/intake position based on two presets
     * @param Joystick from the operator that changes the shooter/intake position
     */
    public void changeShintakePosition(double Dpad)
    {
    		if(Dpad == 90)
    		{
    			SHOOTER_1.set(Math.sqrt(Math.sqrt(SHOOTER_ENCODER.get()/500)));
    			targetPos = 500;
    			ShootPos = 1;
    		}
    		if(Dpad == 180)
    		{
    			SHOOTER_1.set(Math.sqrt(Math.sqrt(((SHOOTER_ENCODER.get()-500)/500)*-1)));
    			targetPos = 0;
    			ShootPos = 2;
    		}
    		if(SHOOTER_ENCODER.get() > targetPos - 5 && SHOOTER_ENCODER.get() < targetPos + 5) 
    		{
    			SHOOTER_1.set(0);
    			if(targetPos == 500) ShootPos = 3;
    			else ShootPos = 0;
    		}
    		if(ShootPos == 1)
    		{
    			SHOOTER_1.set(Math.sqrt(Math.sqrt(SHOOTER_ENCODER.get()/500)));
    		}
    		if(ShootPos == 2)
    		{
    			SHOOTER_1.set(Math.sqrt(Math.sqrt(((SHOOTER_ENCODER.get()-500)/500)*-1)));
    		}
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //TASK LIST FOR SHOOTER/INTAKE
    //
    // 1. Change to POV hat for position changes
    // 2. Add intake functionality - DONE
    // 3. Limit intake modes based position - DONE
    // 4. Remove set point restrictions  - DONE
    // 5. figure out why Michael doesn't sync his code
    // 6. PID
    // 7. Request dead zone in OI
    // 8. Ensure that POV hat is added
    // 9. Fix comments
    // 10. Fix Encoder and victor names
    
}

