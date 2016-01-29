package main.java.org.usfirst.frc.team1360.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import java.util.HashMap;
import java.util.List;

public class AutonomousGroupBuilder extends CommandGroup
{
    private HashMap<Command, String> raw;
    private List<Command> commandList;

    public AutonomousGroupBuilder(HashMap<Command, String> raw)
    {
        this.raw = raw;
        parseHashMap();
    }

    public AutonomousGroupBuilder(List<Command> commandList)
    {
        this.commandList = commandList;
        parseList();
    }

    /**
     * Parse the given HashMap to identify what action in what type (Sequential or Parallel) and
     * the given CommandData
     */
    private void parseHashMap()
    {
        for (Command action : raw.keySet())
        {
            String type = raw.get(action);
            if(type.equals("Parallel"))
                addParallel(action);
            else
                addSequential(action);
        }
    }

    private void parseList()
    {
        for(Command c : commandList)
            addSequential(c);
    }

}
