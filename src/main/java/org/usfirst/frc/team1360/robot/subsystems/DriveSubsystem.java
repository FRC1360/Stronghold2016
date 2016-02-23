package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.RobotMap;
import org.usfirst.frc.team1360.robot.util.FRCMath;

public class DriveSubsystem extends Subsystem
{
    /**
     * LeftMotor Front on the Drive Subsystem
     */
    private final Victor DRIVE_LEFT_1 = new Victor(RobotMap.DRIVESUBSYSTEM_LEFT_1);
    /**
     * LeftMotor Back on the Drive Subsystem
     */
    private final Victor DRIVE_LEFT_2 = new Victor(RobotMap.DRIVESUBSYSTEM_LEFT_2);
    /**
     * RightMotor Front on the Drive Subsystem
     */
    private final Victor DRIVE_RIGHT_1 = new Victor(RobotMap.DRIVESUBSYSTEM_RIGHT_1);
    /**
     * RightMotor Back on the Drive Subsystem
     */
    private final Victor DRIVE_RIGHT_2 = new Victor(RobotMap.DRIVESUBSYSTEM_RIGHT_2);


    private final Encoder DRIVE_RIGHT = new Encoder(RobotMap.DRIVESUBSYSTEM_ENCODERRA, RobotMap.DRIVESUBSYSTEM_ENCODERRB, true);

    private final Encoder DRIVE_LEFT = new Encoder(RobotMap.DRIVESUBSYSTEM_ENCODERLA, RobotMap.DRIVESUBSYSTEM_ENCODERLB, false);


    /**
     * Back solenoid for the lowrider system.
     */
    private final Solenoid SOLENOID_BACK = new Solenoid(RobotMap.DRIVESUBSYSTEM_SOLENOID_BACK);


    @Override
    protected void initDefaultCommand()
    {

    }

    /**
     * Returns the value of an inputted encoder, multiplied by the tick ratio.
     * USE:
     * Distance(DRIVE_LEFT.getRaw());
     *
     * @param encoder enc
     * @return distance
     */
    public double returnMetric(double encoder){return encoder * FRCMath.ENCODER_TICK_RATIO;
    }

    /**
     *  Easy method to return left encoder values
     * @return
     */
    public double getLeft()
    {
        return DRIVE_LEFT.getRaw();
    }

    /**
     * Easy method to return right encoder values
     * @return
     */
    public double getRight()
    {
        return DRIVE_RIGHT.getRaw();
    }

    /**
     * sets speeds of left and right motors
     *
     * @param speedLeft  Left motor front and back speed
     * @param speedRight Right motor front and back speed
     */
    public void tankDrive(double speedLeft, double speedRight)
    {
        DRIVE_LEFT_1.set(-speedLeft);
        DRIVE_LEFT_2.set(-speedLeft);
        DRIVE_RIGHT_1.set(speedRight);
        DRIVE_RIGHT_2.set(speedRight);
    }

    /**
     * The function for arcade drive
     *
     * @param speed Port for speed
     * @param turn  Port for turn
     */
    public void arcadeDrive(double speed, double turn)
    {
        double left = (-turn) - speed;
        double right = (-turn) + speed;

        tankDrive(left, right);
    }

    /**
     * Set up/down state of lowrider.
     *
     * @param state button
     */
    public void changePosition(boolean state)
    {
        SOLENOID_BACK.set(state);
    }

    /**
     * Halts all motors
     */
    public void zeroDrive()
    {
        DRIVE_LEFT_1.set(0);
        DRIVE_LEFT_2.set(0);
        DRIVE_RIGHT_1.set(0);
        DRIVE_RIGHT_2.set(0);
    }
    /**
     * coast is used to drive a set distance in a straight line
     * uses the distance method to compare to a set metric distance by the user
     * will drive the robot to said set distance
     * @param distance
     */
    public void coast(double distance)
    {
        if(returnMetric(getLeft()) < distance + 10 && returnMetric(getLeft()) > distance - 10)
        {
            zeroDrive();
        }

        else if(returnMetric(getLeft()) > distance + 10 && returnMetric(getLeft()) < distance - 10 )
        {
            tankDrive(FRCMath.motorDampening(getLeft(),distance),FRCMath.motorDampening(getRight(),distance));
        }



    }
}
