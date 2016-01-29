package main.java.org.usfirst.frc.team1360.robot.autonomous.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import main.java.org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousExampleCommand;

/**
 * AutonomousExampleCommandGroup - Does XXY - using XXY Commands.
 */
public class AutonomousExampleCommandGroup extends CommandGroup
{
    public AutonomousExampleCommandGroup()
    {
        addSequential(new AutonomousExampleCommand());
    }
}
