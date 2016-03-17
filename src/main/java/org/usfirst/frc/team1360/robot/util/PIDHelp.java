package org.usfirst.frc.team1360.robot.util;


import org.usfirst.frc.team1360.robot.OI;

public class PIDHelp
{
    public static double setpoint;
    public static double adder;

    public static double pivotSetpoint()
    {
        adder = OI.getOperatorPivot()*10;
        if(setpoint > 0 || setpoint < 754){setpoint = setpoint+adder;}
        else if(setpoint > 754 && adder > 0){setpoint = 754;}
        else if(setpoint < 0 && adder < 0){setpoint = 0;}
        return setpoint;
    }
}
