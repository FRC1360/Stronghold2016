package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.RobotMap;

/**
 * Shooter Subsystem.
 */
public class ShooterSubsystem extends Subsystem
{
    private static double Kp = 0;
    private static double Ki = 0;
    private static double Kd = 0;

    private Counter encoder = new Counter(RobotMap.SHOOTER_RPM);

    private VictorSP shooterM = new VictorSP(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_1);
    private final PIDController pid = new PIDController(Kp, Ki, Kd, encoder, shooterM, 15);
    private Solenoid shooterSolenoid = new Solenoid(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_SOLENOID);

    public ShooterSubsystem()
    {

        pid.setInputRange(0, 7000);

        pid.setOutputRange(0, 1);

        encoder.reset();
        encoder.setMaxPeriod(1);

        pid.setAbsoluteTolerance(50);
        pid.enable();

    }

    @Override
    protected void initDefaultCommand()
    {

    }

    public void raw(double speed)
    {
        shooterM.set(speed);
    }

    public void setSpeed(double rpm)
    {
        pid.setSetpoint(rpm);
    }

    public void shoot(boolean state)
    {
        if (pid.onTarget())
        {
            shooterSolenoid.set(state);
        }
    }
}

