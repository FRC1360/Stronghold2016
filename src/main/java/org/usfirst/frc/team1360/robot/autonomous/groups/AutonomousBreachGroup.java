package org.usfirst.frc.team1360.robot.autonomous.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1360.robot.autonomous.AutonomousCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousDriveCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousPivotCommand;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.CommandData;

public class AutonomousBreachGroup extends CommandGroup
{
    private CommandData data;

    public AutonomousBreachGroup(Defense selection, CommandData data)
    {
        this.data = data;
        handleDefenseSelection(selection);
    }

    private void handleDefenseSelection(Defense defense)
    {
        switch (defense)
        {
            /**
             * Move to edge of defense, lower arm, reverse slightly, forward.
             */
            case CHIVAL_DE_FRISE:
                //Move to defense, lower arm, reverse slightly, forward all over.
                break;
            /**
             * These 4 are basically the same thing. Full speed gun it with actuated wheels and the arm
             * being in the up position.
             */
            case MOAT:
            case RAMPARTS:
            case ROCK_WALL:
            case ROUGH_TERRAIN:
                addSequential(new AutonomousPivotCommand(data));
                addParallel(new AutonomousDriveCommand(data));
                break;
            /**
             * Move forward a bit, then drop arm to go under.
             */
            case LOW_BAR:
                data.getObjects().put("auto_pivot_position", PivotSubsystem.Position.INTAKE);
                data.getBooleans().put("auto_drive_actuated", false);
                addParallel(new AutonomousPivotCommand(data));
                addSequential(new AutonomousDriveCommand(data));
                break;
            case LOW_BAR_REVERSE:
                data.getObjects().put("auto_pivot_position", PivotSubsystem.Position.INTAKE);
                data.getBooleans().put("auto_drive_actuated", false);
                data.getDoubles().put("auto_drive_throttle", -data.getDoubles().get("auto_drive_throttle"));
                addParallel(new AutonomousPivotCommand(data));
                addSequential(new AutonomousDriveCommand(data));
            /**
             * Really?
             */
            case NOTHING:
                break;
        }
    }

    // FIRST ITEM IS THE DEFAULT
    public enum Defense
    {
        LOW_BAR,
        LOW_BAR_REVERSE,
        CHIVAL_DE_FRISE,
        RAMPARTS,
        MOAT,
        ROCK_WALL,
        ROUGH_TERRAIN,
        NOTHING
    }

    public enum Direction
    {
        FORWARDS,
        REVERSE
    }
}
