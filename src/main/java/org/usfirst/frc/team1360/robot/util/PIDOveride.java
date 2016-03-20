package org.usfirst.frc.team1360.robot.util;

public class PIDOveride
{
    public static boolean drive = true;
    public static boolean pivot = false;
    public static void driveOveride(boolean RB)
    {
        if (drive == true && RB == true){drive = false;}
        else if(drive == false && RB == true){drive = true;}
    }

    public static void pivotOveride(boolean B)
    {
        if (pivot == true && B == true){pivot = false;}
        else if(pivot == false && B == true){pivot = true;}
    }
}
