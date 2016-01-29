package main.java.org.usfirst.frc.team1360.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.org.usfirst.frc.team1360.robot.RobotMap;

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

    @Override
    protected void initDefaultCommand()
    {

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
