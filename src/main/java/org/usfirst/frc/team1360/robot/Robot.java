package org.usfirst.frc.team1360.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team1360.robot.autonomous.AutonomousGroupBuilder;
import org.usfirst.frc.team1360.robot.autonomous.actions.AutonomousDriveCommand;
import org.usfirst.frc.team1360.robot.util.CommandData;

import java.util.ArrayList;
import java.util.List;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    private List<SendableChooser> choices = new ArrayList<>();
    private List<SendableChooser> variables = new ArrayList<>();

    private Command autonomousCommand;
    
    public static OI oi;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
        for (int i = 0; i < 3; i++)
        {
            SendableChooser c = new SendableChooser();
            choices.add(c);
        }
        oi = new OI();

        LiveWindow.addActuator("IntakeSubsystem", "INTAKE_1", new Victor(1) );

        initAutonomousActions();
    }

    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void autonomousInit()
    {
        // schedule the autonomous command (example)
        autonomousCommand = getAutonomousChoice();
        autonomousCommand.start();
    }

    /**
     * Populate the command data for autonomous
     * @param data to populate
     * @return populated
     */
    private CommandData populateCommandData(CommandData data)
    {
        // Autonomous commands only; as the data is put once
        // Only use for pre-programmed autonomous, not the driver inputted ones.
        //TODO: Make this retrieve values from dashboard
        return data;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit()
    {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }

    private void initAutonomousActions()
    {
        List<Command[]> sections = new ArrayList<>();

        CommandData data = new CommandData();
        data = populateCommandData(data);

        Command nothing = new AutonomousDriveCommand(data);
        Command[] section1 =
                {
                        nothing
                };
        Command[] section2 =
                {
                        nothing
                };
        Command[] section3 =
                {
                        nothing
                };

        sections.add(section1);
        sections.add(section2);
        sections.add(section3);

        for(int i = 0; i < 3; i++)
        {
            SendableChooser s = choices.get(i);
            for(Command c : sections.get(i))
                if (i == 0)
                    s.addDefault(c.getName(), c);
                else
                    s.addObject(c.getName(), c);
        }
    }

    private Command getAutonomousChoice()
    {
        List<Command> actions = new ArrayList<>();
        for (SendableChooser s : choices)
            actions.add((Command) s.getSelected());
        return new AutonomousGroupBuilder(actions);
    }
}
