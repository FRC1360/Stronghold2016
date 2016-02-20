package org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team1360.robot.RobotMap;

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

    private final Encoder DRIVE_RIGHT = new Encoder(RobotMap.DRIVESUBSYSTEM_ENCODERRA,RobotMap.DRIVESUBSYSTEM_ENCODERRB, true);

    private final Encoder DRIVE_LEFT = new Encoder(RobotMap.DRIVESUBSYSTEM_ENCODERLA,RobotMap.DRIVESUBSYSTEM_ENCODERLB, false);
    /**
     * Used as a multiplier to 'Encoder.getRaw()' to get distance travelled in meters
     */
    public final double ENCODER_TICK_RATIO = (20 * Math.PI)/(100 * 1024);
    @Override
    protected void initDefaultCommand()
    {

    }

    /**
     *  Returns the value of an inputted encoder, multiplied by the tick ratio.
     *
     *  USE:
     *  Distance(DRIVE_LEFT.getRaw());
     *
     * @param Encoder
     * @return
     */
    public double Distance(double Encoder)
    {
        return Encoder*ENCODER_TICK_RATIO;
    }

    /**
     * sets speeds of left and right motors
     * @param speedLeft Left motor front and back speed
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
     * @param speed Port for speed
     * @param turn Port for turn
     */
    public void arcadeDrive(double speed, double turn)
    {
        double left = (-turn) - speed;
        double right = (-turn) + speed;

        tankDrive(left, right);
    }
}
