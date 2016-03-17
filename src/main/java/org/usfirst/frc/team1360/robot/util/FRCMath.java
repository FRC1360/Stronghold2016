package org.usfirst.frc.team1360.robot.util;

public class FRCMath
{
    /**
     * Used as a multiplier to 'Encoder.getRaw()' to get distance travelled in meters
     */
    public static final double ENCODER_TICK_RATIO = (20 * Math.PI) / (1064);
    public static final double MAX = 754,MIN = 0;

    /**
     * Used when dampening motors with a setpoint value
     * The value returned will be linear
     * Capable of handling 0 values however, will return 0
     *
     * @param input
     * @param setpoint
     * @return
     */
    public static double motorDampening(double input, double setpoint)
    {
        if (input == 0 || setpoint == 0)
            return 0;
        else if (input > setpoint)
            return -(setpoint / input);
        return input / setpoint;


    }
    /**
     * TODO: Potentiometer ratio.
     */
}
