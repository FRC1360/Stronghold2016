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
import java.util.HashMap;
import java.util.List;

public class DriverstationDashboard
{
    private static List<SendableChooser> choices = new ArrayList<>();

    private static HashMap<String, CommandData.DataType> getCommandDataArgs(Command command)
    {
        HashMap<String, CommandData.DataType> data = new HashMap<>();
        if (command instanceof AutonomousDriveCommand)
        {
            data = ((AutonomousDriveCommand) command).getCommandDataArguments();
        }
        else if (command instanceof AutonomousIntakeCommand)
        {
            data = ((AutonomousIntakeCommand) command).getCommandDataArguments();
        }
        else if (command instanceof AutonomousPivotCommand)
        {
            data = ((AutonomousPivotCommand) command).getCommandDataArguments();
        }
        else if (command instanceof AutonomousShooterCommand)
        {
            data = ((AutonomousShooterCommand) command).getCommandDataArguments();
        }
        return data;
    }

    private static CommandData populateCommandData(Command command)
    {
        CommandData output = new CommandData();
        HashMap<String, CommandData.DataType> data = getCommandDataArgs(command);
        for(String s : data.keySet())
        {
            CommandData.DataType dataType = data.get(s);
            switch(dataType)
            {
                case DOUBLE:
                    output.addDouble(s, 0);
                    break;
                case BOOLEAN:
                    output.addBoolean(s, false);
                    break;
                case FLOAT:
                    output.addFloat(s, 0f);
                    break;
            }
        }
        return output;
    }

    private static void addSendables()
    {
        for (int i = 0; i < choices.size(); i++)
        {
            SendableChooser c = choices.get(i);
            SmartDashboard.putData("Autonomous " + i, c);
        }
    }

    private static void initAutonomousActions()
    {
        List<Command[]> sections = new ArrayList<>();


        Command[] section1 =
                {
                    new AutonomousDriveCommand()
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
    private static HashMap<String, CommandData.DataType> getAllCommandDataArgs()
    {
        AutonomousDriveCommand driveCommand = new AutonomousDriveCommand();
        AutonomousPivotCommand pivotCommand = new AutonomousPivotCommand();
        AutonomousShooterCommand shooterCommand = new AutonomousShooterCommand();
        AutonomousIntakeCommand intakeCommand = new AutonomousIntakeCommand();
        HashMap<String, CommandData.DataType> data = new HashMap<>();

        data.putAll(driveCommand.getCommandDataArguments());
        data.putAll(pivotCommand.getCommandDataArguments());
        data.putAll(shooterCommand.getCommandDataArguments());
        data.putAll(intakeCommand.getCommandDataArguments());
        return data;
    }


    private static void putValues()
    {
        HashMap<String, CommandData.DataType> data = getAllCommandDataArgs();

        for(String s : data.keySet())
        {
            CommandData.DataType dataType = data.get(s);
            switch (dataType)
            {
                case BOOLEAN:
                    SmartDashboard.putBoolean(s, false);
                    break;
                case DOUBLE:
                case FLOAT:
                    SmartDashboard.putNumber(s, 0);
                    break;
            }
        }
    }

    private static HashMap<String,Double> getValues()
    {
        HashMap<String, Double> values = new HashMap<>();

        HashMap<String, CommandData.DataType> data = getAllCommandDataArgs();
        for(String s : data.keySet())
            values.put(s, SmartDashboard.getNumber(s));
        return values;
    }

    public static void init()
    {
        for (int i = 0; i < 3; i++)
        {
            SendableChooser c = new SendableChooser();
            choices.add(c);
        }
        addSendables();
        putValues();
        initAutonomousActions();
    }

    public static Command getAutonomousChoice()
    {
        List<Command> actions = new ArrayList<>();
        for (SendableChooser s : choices)
            actions.add((Command) s.getSelected());
        return new AutonomousGroupBuilder(actions);
    }
}
