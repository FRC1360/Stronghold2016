package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1360.robot.RobotMap;

/**
 * Shooter Subsystem.
 */
public class ShooterSubsystem extends Subsystem {

    private Counter encoder = new Counter(RobotMap.SHOOTER_RPM);

    private VictorSP shooterM = new VictorSP(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_1);

    private Solenoid shooterSolenoid = new Solenoid(RobotMap.SHOOTERSUBSYSTEM_SHOOTER_SOLENOID);

    public ShooterSubsystem() {


        encoder.setDistancePerPulse(1);
        encoder.setMaxPeriod(60);


    }

    @Override
    protected void initDefaultCommand() {

    }


    double realRate() {
        return encoder.getRate() / 0.01 / 2;
    }

    public void raw(double speed) {

        if (realRate() < 7000)
        {
            shooterM.set(speed);
        }
        else
        shooterM.set(0);



    }
    public void shoot(boolean arg)
    {
        if (realRate() > 6800 && realRate() < 7200 || realRate() == 0){shooterSolenoid.set(arg);}
    }

}
