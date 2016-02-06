package main.java.org.usfirst.frc.team1360.robot.subsystems;

import main.java.org.usfirst.frc.team1360.robot.RobotMap;

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
    
    public void getSpeed() //Work in progress
    {
    	double period = 0.5;
    	//SHOOTER_ENCODER.setDistancePerPulse(period);
    	//double speed = SHOOTER_ENCODER.getDistance(); //based off of period
    	//double speed2 = SHOOTER_ENCODER.getRaw(); //unaffected by the modifier
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

