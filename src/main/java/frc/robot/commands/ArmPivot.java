package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Arm;
import frc.robot.Constants.MechConstants;

public class ArmPivot extends InstantCommand{

    private Arm arm;

    public ArmPivot(){

        arm = Arm.getInstance();
        addRequirements(arm);

    }

    @Override
    public void initialize(){
        arm.stop();
    }

    @Override
    public void execute(){
        arm.pivot(MechConstants.ARM_PIVOT_SPEED);
    }

    @Override
    public void end(boolean interrupted){
        arm.stop();
    }

    @Override
    public boolean isFinished() {
      return false;
    }




    


    
}
