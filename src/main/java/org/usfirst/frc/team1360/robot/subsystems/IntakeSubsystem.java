package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.RobotMap;

public class IntakeSubsystem extends PIDSubsystem
{

    /**
     * Motor for intake
     */
	private final Victor INTAKE_1 = new Victor(RobotMap.INTAKESUBSYSTEM_INTAKE_1);

    /**
     * *IMPORTANT*
     * This AnalogInput is not complete.
     * It should not map to INTAKE_ENCODER.
     * I need something in RobotMap
     *
     * Plz Jaime-wan.  You're my only hope
     */
    private final AnalogInput INPUT_1 = new AnalogInput(RobotMap.INTAKESUBSYSTEM_ENCODER);


    public IntakeSubsystem()
    {
        super("IntakeSubsystem", 2.0, 0.0, 0.0);
        setAbsoluteTolerance(0.05);
        getPIDController().setContinuous(false);
    }
	
    @Override
    protected void initDefaultCommand()
    {

    }

    /**
     *
     * @param motor The motor that will be spinning for the intake
     */
    public void intakeBoulder(double motor)
    {
        /**
         * This is a deadzone to stop drift of the intake motor
         */
    	if(Math.abs(motor) < 0.15) motor = 0;
        INTAKE_1.set(motor);
    }

    @Override
    protected double returnPIDInput()
    {
        return INPUT_1.getAverageValue();
    }

    @Override
    public void usePIDOutput(double output)
    {
        INTAKE_1.pidWrite(output);
    }
}
