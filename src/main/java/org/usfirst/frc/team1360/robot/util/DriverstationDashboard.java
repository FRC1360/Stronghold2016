package org.usfirst.frc.team1360.robot.util;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1360.robot.autonomous.AutonomousCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousDriveCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousShooterCommand;
import org.usfirst.frc.team1360.robot.autonomous.groups.AutonomousBreachGroup;

import java.util.ArrayList;
import java.util.List;

public class DriverstationDashboard
{
    private static SendableChooser sendableChooser = new SendableChooser();
    private CommandData data;

    public DriverstationDashboard(CommandData data)
    {
        this.data = data;
    }


    public void initAutoSelection()
    {
        boolean first = false;
        for (AutonomousBreachGroup.Defense d : AutonomousBreachGroup.Defense.values())
        {
            if (!first)
            {
                first = true;
                sendableChooser.addDefault(d.name().replaceAll("_", " "), d);
                continue;
            }
            sendableChooser.addObject(d.name().replaceAll("_", " "), d);
        }
        SmartDashboard.putData("BreachAuto", sendableChooser);
    }

    public CommandGroup getAutoSelection()
    {
        return new AutonomousBreachGroup((AutonomousBreachGroup.Defense) sendableChooser.getSelected(), data);
    }
}
