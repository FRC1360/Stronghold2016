package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.RobotMap;

public class IntakeSubsystem extends Subsystem 
{

	
	private final Victor INTAKE_1 = new Victor(RobotMap.INTAKE_MOTOR);
	
    @Override
    protected void initDefaultCommand()
    {

    }

    public void intakeBoulder(double motor)
    {
    	if(Math.abs(motor) < 0.15) motor = 0;
    	
        INTAKE_1.set(motor);
    }
}
