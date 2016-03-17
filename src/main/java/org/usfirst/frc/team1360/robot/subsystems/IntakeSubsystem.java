package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.RobotMap;

public class IntakeSubsystem extends Subsystem
{

    /**
     * Motor for intake
     */
    private final Victor INTAKE_1 = new Victor(RobotMap.INTAKESUBSYSTEM_INTAKE_1);

    @Override
    protected void initDefaultCommand()
    {

    }

    /**
     * Intake the ball
     *
     * @param speed Speed
     */
    public void intakeBoulder(double speed)
    {
        INTAKE_1.set(speed);

    }
}
