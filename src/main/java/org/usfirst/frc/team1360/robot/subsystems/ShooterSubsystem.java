package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.usfirst.frc.team1360.robot.RobotMap;
import org.usfirst.frc.team1360.robot.commands.ShooterCommand;

/**
 * Shooter Subsystem.
 */
public class ShooterSubsystem extends Subsystem implements PIDSource, PIDOutput
{
    private double P = 0;
    private double I = 0;
    private double D = 0;

    public ShooterSubsystem()
    {
        shooterPIDLoop.setAbsoluteTolerance(0.15);
        shooterPIDLoop.setContinuous(false);
        shooterPIDLoop.reset();
    }
    /**
     * Timer for shooting delay.
     */
    Timer timer = new Timer();
    /**
     * Shooter motor
     */
    Victor SHOOTER_1 = new Victor(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_1);

    /**
     * Shooter solenoid
     */
    Solenoid SHOOT_SOLENOID = new Solenoid(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_SOLENOID);



    /**
     * Assuming geartooth to make my life easier.
     */
    public GearTooth encoder = new GearTooth(RobotMap.SHOOTER_RPM);

    /**
     * Clean way to manage PID from within a class.
     */
    PIDController shooterPIDLoop = new PIDController(P, I ,D, this, this);

    public void shoot()
    {
        if(shooterPIDLoop.onTarget())
        {
            timer.start();
            SHOOT_SOLENOID.set(true);
            if(timer.hasPeriodPassed(0.15))
                SHOOT_SOLENOID.set(false);
        }
        timer.reset();
    }
    public void shoot(boolean act)
    {

            SHOOT_SOLENOID.set(act);



    }
    public void shoot(double in,boolean out)
    {
        if(out == true){SHOOTER_1.set(0.25);}
        else
        {
            SHOOTER_1.set(in);
        }
    }

    public void initDefaultCommand()
    {

    }

    @Override
    public void pidWrite(double output)
    {
        SHOOTER_1.set(output);
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource)
    {
    }

    @Override
    public PIDSourceType getPIDSourceType()
    {
        return PIDSourceType.kRate;
    }

    @Override
    public double pidGet()
    {
        // TODO: Need to find out conversion between RPM and wheel.


        return (encoder.getPeriod());
    }
}

