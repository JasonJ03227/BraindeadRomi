package frc.robot.sensors;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDouble;

public class RomiGyro {
  private SimDouble m_simRateX;
  
  private SimDouble m_simRateY;
  
  private SimDouble m_simRateZ;
  
  private SimDouble m_simAngleX;
  
  private SimDouble m_simAngleY;
  
  private SimDouble m_simAngleZ;
  
  private double m_angleXOffset;
  
  private double m_angleYOffset;
  
  private double m_angleZOffset;
  
  public RomiGyro() {
    SimDevice gyroSimDevice = SimDevice.create("Gyro:RomiGyro");
    if (gyroSimDevice != null) {
      gyroSimDevice.createBoolean("init", SimDevice.Direction.kOutput, true);
      this.m_simRateX = gyroSimDevice.createDouble("rate_x", SimDevice.Direction.kInput, 0.0D);
      this.m_simRateY = gyroSimDevice.createDouble("rate_y", SimDevice.Direction.kInput, 0.0D);
      this.m_simRateZ = gyroSimDevice.createDouble("rate_z", SimDevice.Direction.kInput, 0.0D);
      this.m_simAngleX = gyroSimDevice.createDouble("angle_x", SimDevice.Direction.kInput, 0.0D);
      this.m_simAngleY = gyroSimDevice.createDouble("angle_y", SimDevice.Direction.kInput, 0.0D);
      this.m_simAngleZ = gyroSimDevice.createDouble("angle_z", SimDevice.Direction.kInput, 0.0D);
    } 
  }
  
  public double getRateX() {
    if (this.m_simRateX != null)
      return this.m_simRateX.get(); 
    return 0.0D;
  }
  
  public double getRateY() {
    if (this.m_simRateY != null)
      return this.m_simRateY.get(); 
    return 0.0D;
  }
  
  public double getRateZ() {
    if (this.m_simRateZ != null)
      return this.m_simRateZ.get(); 
    return 0.0D;
  }
  
  public double getAngleX() {
    if (this.m_simAngleX != null)
      return this.m_simAngleX.get() - this.m_angleXOffset; 
    return 0.0D;
  }
  
  public double getAngleY() {
    if (this.m_simAngleY != null)
      return this.m_simAngleY.get() - this.m_angleYOffset; 
    return 0.0D;
  }
  
  public double getAngleZ() {
    if (this.m_simAngleZ != null)
      return this.m_simAngleZ.get() - this.m_angleZOffset; 
    return 0.0D;
  }
  
  public void reset() {
    if (this.m_simAngleX != null) {
      this.m_angleXOffset = this.m_simAngleX.get();
      this.m_angleYOffset = this.m_simAngleY.get();
      this.m_angleZOffset = this.m_simAngleZ.get();
    } 
  }
}