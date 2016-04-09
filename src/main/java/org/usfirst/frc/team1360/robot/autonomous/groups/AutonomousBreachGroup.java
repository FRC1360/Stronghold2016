package org.usfirst.frc.team1360.robot.autonomous.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1360.robot.autonomous.AutonomousCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousDriveCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousIntakeCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousPivotCommand;
import org.usfirst.frc.team1360.robot.subsystems.PivotSubsystem;
import org.usfirst.frc.team1360.robot.util.CommandData;

import java.util.Arrays;

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
                break;
            case LOW_BAR_LOW_GOAL:
                data = lowGoalTimings(data);
                addParallel(new AutonomousPivotCommand(data));
                addSequential(new AutonomousDriveCommand(data));
                data.getObjects().put("auto_drive_turn", Arrays.asList(0.5, 0.5));
                data.getDoubles().put("auto_drive_turn_time", 3D);
                addSequential(new AutonomousDriveCommand(data));
                addSequential(new AutonomousDriveCommand(data));
                data.getObjects().remove("auto_drive_turn");
                data.getDoubles().remove("auto_drive_turn_time");
                addSequential(new AutonomousIntakeCommand(data));
            /**
             * Really?
             */
            case NOTHING:
                break;
        }
    }

    private CommandData lowGoalTimings(CommandData data)
    {
        data.getObjects().put("auto_pivot_position", PivotSubsystem.Position.BATTER_CLEAR);
        data.getBooleans().put("auto_drive_actuated", false);
        data.getDoubles().put("auto_drive_throttle", 0.5);
        data.getDoubles().put("auto_intake_speed", 0.25);
        data.getDoubles().put("auto_intake_time", 2D);
        return data;
    }

    // FIRST ITEM IS THE DEFAULT
    public enum Defense
    {
        LOW_BAR,
        LOW_BAR_REVERSE,
        LOW_BAR_LOW_GOAL,
        CHIVAL_DE_FRISE,
        RAMPARTS,
        MOAT,
        ROCK_WALL,
        ROUGH_TERRAIN,
        NOTHING
    }
}
