package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.VisionConstants;
import frc.robot.utils.AprilCam;


public class Camera extends SubsystemBase {

  private AprilCam cam;
  private static Camera instance;

  private Camera() {
    this.cam = new AprilCam(VisionConstants.APRIL_CAM_NAME);
    cam.update();
  }

  public static Camera getInstance() {
    if (instance == null) {
      instance = new Camera();
    }
    return instance;
  }

  public AprilCam getCam() {
    return cam;
  }

  public double getX(){
    return cam.getX();
  }

  public double getY(){
    return cam.getY();
  }

  public double getZ(){
    return cam.getZ();
  }


  @Override
  public void periodic() {
    cam.update();
    SmartDashboard.putBoolean("hasTargetNew", cam.hasTarget());
    SmartDashboard.putNumber("BestID", cam.getBestID());
    SmartDashboard.putNumber("X", getX());
    SmartDashboard.putNumber("Y", getY());
    SmartDashboard.putNumber("Z", getZ());
  }
}