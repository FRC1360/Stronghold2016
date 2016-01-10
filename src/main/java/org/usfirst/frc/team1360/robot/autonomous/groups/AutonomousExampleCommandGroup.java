package org.usfirst.frc.team1360.robot.autonomous.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousExampleCommand;

public class AutonomousExampleCommandGroup extends CommandGroup
{
    public AutonomousExampleCommandGroup()
    {
        addSequential(new AutonomousExampleCommand());
    }
}
