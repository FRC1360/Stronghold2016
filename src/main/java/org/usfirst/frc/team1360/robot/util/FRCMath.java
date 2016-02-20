package org.usfirst.frc.team1360.robot.util;

public class FRCMath
{
    /**
     * Used as a multiplier to 'Encoder.getRaw()' to get distance travelled in meters
     */
    public static final double ENCODER_TICK_RATIO = (20 * Math.PI)/(100 * 1024);
}
