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


    public static final int INTAKESUBSYSTEM_INTAKE_1 =          4;


    public static final int SHOOTERSUBSYSTEM_SHOOTER_1 = INTAKESUBSYSTEM_INTAKE_1;


    public static final int SHOOTERSUBSYSTEM_TILTER =           5;


    // Solenoids

    public static final int DRIVESUBSYSTEM_SOLENOID_BACK =    0;

    public static final int DRIVESUBSYSTEM_SOLENOID_MID =       1;

    public static final int SHOOTERSUBSYSTEM_SHOOTER_SOLENOID = 2;


    /**
     * Driver Controller
     */
    public static final int JOYSTICK_DRIVER =                   0;
    /**
     * Operator Controller
     */
    public static final int JOYSTICK_OPERATOR =                 1;
}
