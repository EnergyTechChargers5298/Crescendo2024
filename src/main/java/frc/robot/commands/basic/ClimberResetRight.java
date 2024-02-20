package frc.robot.commands.basic;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climber;


public class ClimberResetRight extends Command {

  private Climber climber;
  
  /** Creates a new RightClimberReset. */
  public ClimberResetRight() {
  
    climber = Climber.getInstance();
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(climber);
   }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climber.resetRightEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
