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
    public static final int DRIVESUBSYSTEM_LEFT_1 = 0;
    /**
     * LeftMotor Back on the Drive Subsystem
     * CAN: No
     */
    public static final int DRIVESUBSYSTEM_LEFT_2 = 1;
    /**
     * RightMotor Front on the Drive Subsystem
     * CAN: No
     */
    public static final int DRIVESUBSYSTEM_RIGHT_1 = 2;
    /**
     * RightMotor Back on the Drive Subsystem
     * CAN: No
     */
    public static final int DRIVESUBSYSTEM_RIGHT_2 = 3;

    /**
     * IntakeMotor on the shintake
     * CAN: No
     */
    public static final int INTAKESUBSYSTEM_INTAKE_1 = 4;
    /**
     * PivotMotor on the base of the shintake
     * CAN: No
     */
    public static final int PIVOTSUBSYSTEM_TILTER = 5;

    /**
     * ShooterMotor on the shintake
     * CAN: No
     */
    public static final int SHOOTERSUBSYSTEM_SHOOTER_1 = 6;


    // Encoders

    public static final int DRIVESUBSYSTEM_ENCODERLA = 0;

    public static final int DRIVESUBSYSTEM_ENCODERLB = 1;

    public static final int DRIVESUBSYSTEM_ENCODERRA = 0;

    public static final int DRIVESUBSYSTEM_ENCODERRB = 1;

    //Potentiometers
    public static final int PIVOTSUBSYSTEM_POT = 0;

    // Solenoids

    public static final int DRIVESUBSYSTEM_SOLENOID_BACK = 0;

    public static final int SHOOTERSUBSYSTEM_SHOOTER_SOLENOID = 1;


    /**
     * Driver Controller
     */
    public static final int JOYSTICK_DRIVER = 0;
    /**
     * Operator Controller
     */
    public static final int JOYSTICK_OPERATOR = 1;
}
