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
     * Driver Controller
     */
    static final int JOYSTICK_DRIVER = 0;
    /**
     * Operator Controller
     */
    static final int JOYSTICK_OPERATOR = 1;

    //region PWM
    //region Motors
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

    //endregion
    //endregion

    //region AnalogInput
    /**
     * Pivot Potentiometer
     */
    public static final int PIVOTSUBSYSTEM_POT = 0;
    //endregion

    //region Digital Input
    /**
     * Banner Sensor for shooter RPM
     */
    public static final int SHOOTER_RPM = 0;
    /**
     * Proxy Sensor
     */
    public static final int SHOOTERSUBSYSTEM_SWITCH_DOWN = 1;

    /**
     * Proxy Sensor
     */
    public static final int SHOOTERSUBSYSTEM_SWITCH_UP = 2;

    //region Encoders
    /**
     * Encoder on the left side of the drivetrain
     * USED:NO
     */
    public static final int DRIVESUBSYSTEM_ENCODERLA = 3;
    /**
     * Encoder on the left side of the drivetrain
     * USED:NO
     */
    public static final int DRIVESUBSYSTEM_ENCODERLB = 4;
    /**
     * Encoder on the right side of the drivetrain
     * USED:NO
     */
    public static final int DRIVESUBSYSTEM_ENCODERRA = 5;
    /**
     * Encoder on the right side of the drivetrain
     * USED:NO
     */
    public static final int DRIVESUBSYSTEM_ENCODERRB = 6;
    //endregion
    //endregion

    //region Solenoids
    /**
     * Solenoid for actuating drivetrain
     */
    public static final int DRIVESUBSYSTEM_SOLENOID_BACK = 0;
    /**
     * Solenoid for actuating the shooter
     */
    public static final int SHOOTERSUBSYSTEM_SHOOTER_SOLENOID = 1;

    /**
     * Solenoid for opening up the climber
     */
    public static final int CLIMBERSUBSYSTEM_CLIMBER_ENABLE = 2;

    /**
     * Solenoid for engaging the drivetrain.
     */
    public static final int CLIMBERSUBSYSTEM_CLIMBER_DRIVE = 3;
    //endregion

}
