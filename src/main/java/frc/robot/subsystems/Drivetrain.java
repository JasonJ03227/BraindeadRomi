// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.sensors.RomiGyro;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterMeter = 0.070000114;

  //Romi Motors
  private final Spark m_leftMotor = new Spark(0);
  private final Spark m_rightMotor = new Spark(1);

  //Encoders
  private final Encoder m_leftEncoder = new Encoder(4, 5);
  private final Encoder m_rightEncoder = new Encoder(6, 7);

  //Differential Drive
  private final DifferentialDrive m_dDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  //Romi Gyro
  private final  RomiGyro m_gyro = new RomiGyro();
  
  //BuiltInAccelerometer
  private final BuiltInAccelerometer m_accelerometer = new BuiltInAccelerometer();
  
  //Drivetrain 
  public Drivetrain() {
    m_rightMotor.setInverted(true);
    m_leftEncoder.setDistancePerPulse(Math.PI * kWheelDiameterMeter / kCountsPerRevolution);
    m_rightEncoder.setDistancePerPulse(Math.PI * kWheelDiameterMeter / kCountsPerRevolution);
    resetEncoders();
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    m_dDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }
  public void resetEncoders(){ 
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  public int getLeftEncoderCount() {
    return m_leftEncoder.get();
  }

  public double getLeftEncoderDistanceMeter() {
    return m_leftEncoder.getDistance();
  }
  
  public int getRightEncoderCount() {
    return m_rightEncoder.get();
  }

  public double getRightEncoderDistanceMeter() {
    return m_rightEncoder.getDistance();
  }

public double getAverageDistanceMeters() {
  return (getLeftEncoderDistanceMeter() + getRightEncoderDistanceMeter()) / 2.0;
}

//X Axis Acceleration
public double getAccelX() {
  return m_accelerometer.getX();
}

//Y Axis Acceleration
public double getAccelY() {
  return m_accelerometer.getY();
}

//Z Axis Acceleration
public double getAccelZ() {
  return m_accelerometer.getZ();
}

//Gyro X Axis
public double getGyroAngleX() {
  return m_gyro.getAngleX();
}

//Gyro Y Axis
public double getGyroAngleY() {
  return m_gyro.getAngleY();
}

//Gyro Z Axis
public double getGyroAngleZ() {
  return m_gyro.getAngleZ();
}

public void resetGyro() {
  m_gyro.reset();
}

@Override
public void periodic() {
  }
}
