package org.usfirst.frc.team1360.robot.util;

public class FRCMath
{
    /**
     * Used as a multiplier to 'Encoder.getRaw()' to get distance travelled in meters
     */
    public static final double ENCODER_TICK_RATIO = (20 * Math.PI) / (100 * 1024);

    /**
     * Used when dampening motors with a setpoint value
     * The value returned will be linear
     * Capable of handling 0 values however, will return 0
     * @param input
     * @param setpoint
     * @return
     */
    public static double motorDampening(double input, double setpoint)
    {
        if(input == 0 || setpoint == 0){return 0;}
        else
        {
            if (input > setpoint) {return -(setpoint / input);}
            else{return input/setpoint;}
        }

    }
    /**
     * TODO: Potentiometer ratio.
     */
}
