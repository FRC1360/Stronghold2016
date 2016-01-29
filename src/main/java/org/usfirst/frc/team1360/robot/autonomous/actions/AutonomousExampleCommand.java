package main.java.org.usfirst.frc.team1360.robot.autonomous.actions;

import edu.wpi.first.wpilibj.command.Command;
import main.java.org.usfirst.frc.team1360.robot.util.CommandData;

/**
 * AutonomousExampleCommand - Does XXY Function on XXY Subsystem
 */
public class AutonomousExampleCommand extends Command
{
    private double left;
    private double right;
    private boolean toggle;

    public AutonomousExampleCommand(CommandData commandData)
    {
        left = commandData.getDoubles().get("left");
        right = commandData.getDoubles().get("right");
        toggle = commandData.getBooleans().get("toggle");
    }

    public AutonomousExampleCommand(double left, double right, boolean toggle)
    {

    }
    public AutonomousExampleCommand()
    {

    }

    @Override
    protected void initialize()
    {

    }

    @Override
    protected void execute()
    {

    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void end()
    {

    }

    @Override
    protected void interrupted()
    {

    }
}
