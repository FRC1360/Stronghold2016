package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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

    private final Encoder DRIVE_LEFT = new Encoder(RobotMap.DRIVESUBSYSTEM_ENCODERLA, RobotMap.DRIVESUBSYSTEM_ENCODERLB, true);


    /**
     * Back solenoid for the lowrider system.
     */
    private final Solenoid SOLENOID_BACK = new Solenoid(RobotMap.DRIVESUBSYSTEM_SOLENOID_BACK);
    private double setpoint;
    private boolean overide;


    public DriveSubsystem()
    {

    }

    private static double encToJoystick(double enc)
    {
        return enc/4;
    }

    protected void initDefaultCommand()
    {

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
    public void arcadeDrive(double turn, double speed)
    {

        if(turn > 0 || turn < 0)
        {
            double left = (-speed) - turn;
            double right = (-speed) + turn;
            tankDrive(left, right);
            overide = true;
        }
        else
            overide = false;



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
     *
     *
     */
}
