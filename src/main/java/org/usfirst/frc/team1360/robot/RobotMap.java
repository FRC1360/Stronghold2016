package org.usfirst.frc.team1360.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    /**
     * LeftMotor Front on the Drive Subsystem
     * CAN: No
     */
    public static final int DRIVESUBSYSTEM_LEFT_1 =             0;
    /**
     * LeftMotor Back on the Drive Subsystem
     * CAN: No
     */
    public static final int DRIVESUBSYSTEM_LEFT_2 =             1;
    /**
    * RightMotor Front on the Drive Subsystem
    * CAN: No
     */
    public static final int DRIVESUBSYSTEM_RIGHT_1 =            2;
    /**
    * RightMotor Back on the Drive Subsystem
    * CAN: No
    */
    public static final int DRIVESUBSYSTEM_RIGHT_2 =            3;

    /**
     * Driver Controller
     */
    public static final int JOYSTICK_DRIVER =                   0;
    /**
     * Operator Controller
     */
    public static final int JOYSTICK_OPERATOR =                 1;

}
