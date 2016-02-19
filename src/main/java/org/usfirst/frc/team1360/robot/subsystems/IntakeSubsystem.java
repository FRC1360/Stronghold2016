package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team1360.robot.RobotMap;

public class IntakeSubsystem extends PIDSubsystem
{

    /**
     * Motor for intake
     */
	private final Victor INTAKE_1 = new Victor(RobotMap.INTAKESUBSYSTEM_INTAKE_1);

    /**
     * Encoder for PID loop
     */
    private final Encoder ENCODER_1 = new Encoder(RobotMap.INTAKESUBSYSTEM_ENCODERA, RobotMap.INTAKESUBSYSTEM_ENCODERB);


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
     * @param speed Speed
     */
    public void intakeBoulder(double speed)
    {
        INTAKE_1.set(speed);
    }

    @Override
    protected double returnPIDInput()
    {
        return ENCODER_1.pidGet();
    }

    @Override
    public void usePIDOutput(double output)
    {
        INTAKE_1.pidWrite(output);
    }
}
