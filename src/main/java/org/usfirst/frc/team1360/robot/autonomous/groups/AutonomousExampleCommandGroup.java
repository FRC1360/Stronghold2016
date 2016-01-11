package org.usfirst.frc.team1360.robot.autonomous.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousExampleCommand;
import org.usfirst.frc.team1360.robot.util.CommandData;

/**
 * AutonomousExampleCommandGroup - Does XXY - using XXY Commands.
 */
public class AutonomousExampleCommandGroup extends CommandGroup
{
    private CommandData exampleCommandData = new CommandData();
    private void init()
    {
        exampleCommandData.addBoolean(false);
    }
    public AutonomousExampleCommandGroup()
    {
        addSequential(new AutonomousExampleCommand(exampleCommandData));
    }
}
