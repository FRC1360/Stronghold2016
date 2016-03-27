package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1360.robot.RobotMap;
import org.usfirst.frc.team1360.robot.util.Subsystems;

/**
 * Shooter Subsystem.
 */
public class ShooterSubsystem extends Subsystem
{

    private Counter encoder = new Counter(RobotMap.SHOOTER_RPM);

    private VictorSP shooterM = new VictorSP(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_1);

    private Solenoid shooterSolenoid = new Solenoid(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_SOLENOID);


    public ShooterSubsystem()
    {


        encoder.setDistancePerPulse(1); //rate is set per rotation
        encoder.setMaxPeriod(.1);


    }

    @Override
    protected void initDefaultCommand()
    {

    }

    /**
     * returns the value of encoder.getRate(), divided by the period to multiply the number to RPM's
     * then divided by two as every rotations has two pulses, a high pulse and a low pulse.
     *
     * @return rate
     */
    private double realRate()
    {
        return encoder.getRate() / encoder.getPeriod()/2;
    }

    /**
     * shooterRPM will allow for direct input from an RPM controller
     * such as a joystick or a trigger, as long as the RPM of the wheel
     * is lower then 7000, as determined by realRate(). Otherwise the motor
     * cuts power to return to firing target RPMs
     *
     * @param speed input
     */
    public void shooterRPM(double speed)
    {

        //slight buffer in RPMs to stay near the shooting target RPM
        if (realRate() < 8200)
        {
            shooterM.set(speed);

        } else
        {
            shooterM.set(0);

        }
        System.out.println("RPM: "+realRate());


    }
    public void autoShoot(double speed)
    {
        boolean prime;
        shooterRPM(speed);
        prime = realRate() < 8000;
        shoot(prime);


    }
    /**
     * Shoot actuates the shooting piton only when in the range of shooting
     * target RPMs, it allows for driver error and will prime the shooter when RPMs are
     * at 0 incase the driver failed to keep RPMs for the shooter to reprime
     * @param arg to shoot or not to shoot
     */
    public void shoot(boolean arg)
    {
        if (realRate() > 8000 && realRate() < 8400|| !arg || Subsystems.PIVOT_SUBSYSTEM.getSetpoint() < 50)
        {
            shooterSolenoid.set(arg);


        }
    }

}
