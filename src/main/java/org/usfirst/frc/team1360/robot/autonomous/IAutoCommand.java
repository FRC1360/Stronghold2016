package org.usfirst.frc.team1360.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1360.robot.util.CommandData;

import java.util.HashMap;

public interface IAutoCommand
{
    CommandData getCommandData();

    HashMap<String, CommandData.DataType> getCommandDataArguments();

    Command newCommandDataInstance(CommandData data);
}
