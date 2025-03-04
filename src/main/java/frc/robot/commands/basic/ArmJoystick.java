package frc.robot.commands.basic;


import frc.robot.subsystems.Arm;
import java.util.function.Supplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;


public class ArmJoystick extends Command {

  private Arm arm;
  private Supplier<Double> speedX;
  //private Supplier<Boolean> armReset;
  
  /** Creates a new LauncherJoystick. */
  public ArmJoystick(Supplier<Double> speedX) {
    this.speedX = speedX;  
    //this.armReset = armReset;  
    arm = Arm.getInstance();
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.pivot(0);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        arm.pivot(MathUtil.applyDeadband(speedX.get(), 0.1));

        // if(armReset.get()){
        //   arm.resetValue();
        // }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

        arm.pivot(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
