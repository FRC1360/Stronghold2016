package org.usfirst.frc.team1360.robot.util;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1360.robot.autonomous.AutonomousGroupBuilder;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousDriveCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousIntakeCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousPivotCommand;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousShooterCommand;

import java.util.ArrayList;
import java.util.List;

public class DriverstationDashboard
{
    private static List<SendableChooser> choices = new ArrayList<>();

    /**
     * Populate the command data for autonomous
     *
     * @param data   to populate
     * @param choice what argument in the list.
     * @return populated
     */
    private CommandData populateCommandData(CommandData data, int choice)
    {
        Command command = (Command) choices.get(choice).getSelected();
        if (command instanceof AutonomousDriveCommand)
        {
            data = ((AutonomousDriveCommand) command).getCommandData();
        }
        else if (command instanceof AutonomousIntakeCommand)
        {
            data = ((AutonomousIntakeCommand) command).getCommandData();
        }
        else if (command instanceof AutonomousPivotCommand)
        {
            data = ((AutonomousPivotCommand) command).getCommandData();
        }
        else if (command instanceof AutonomousShooterCommand)
        {
            data = ((AutonomousShooterCommand) command).getCommandData();
        }
        return data;
    }

    private static void addSendables()
    {
        for (int i = 0; i < choices.size(); i++)
        {
            SendableChooser c = choices.get(i);
            SmartDashboard.putData("Autonomous " + i, c);
        }
    }

    private void initAutonomousActions()
    {
        List<Command[]> sections = new ArrayList<>();

        Command[] section1 =
                {

                };
        Command[] section2 =
                {

                };
        Command[] section3 =
                {

                };

        sections.add(section1);
        sections.add(section2);
        sections.add(section3);

        for (int i = 0; i < 3; i++)
        {
            SendableChooser s = choices.get(i);
            for (Command c : sections.get(i))
                if (i == 0)
                    s.addDefault(c.getName(), c);
                else
                    s.addObject(c.getName(), c);
        }
    }

    public static void init()
    {
        for (int i = 0; i < 3; i++)
        {
            SendableChooser c = new SendableChooser();
            choices.add(c);
        }
        addSendables();

    }

    public static Command getAutonomousChoice()
    {
        List<Command> actions = new ArrayList<>();
        for (SendableChooser s : choices)
            actions.add((Command) s.getSelected());
        return new AutonomousGroupBuilder(actions);
    }
}
