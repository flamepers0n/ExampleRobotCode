// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DifferentialDrive. */
  private final WPI_TalonFX m_FrontLeftMotor;
  private final WPI_TalonFX m_FrontRightMotor;
  private final WPI_TalonFX m_BackLeftMotor;
  private final WPI_TalonFX m_BackRightMotor;
  private final MotorControllerGroup m_RightMotors;
  private final MotorControllerGroup m_LeftMotors;
  private final DifferentialDrive m_DifferentialDrive;
  private boolean invertDrive = false;

  public DriveTrain() 
  {
    m_FrontLeftMotor = new WPI_TalonFX(DriveTrainConstants.kFrontLeftCanId);  
    m_FrontRightMotor = new WPI_TalonFX(DriveTrainConstants.kFrontRightCanId);
    m_BackLeftMotor = new WPI_TalonFX(DriveTrainConstants.kBackLeftCanId);
    m_BackRightMotor = new WPI_TalonFX(DriveTrainConstants.kBackRightCanId);

    m_LeftMotors = new MotorControllerGroup(m_FrontLeftMotor, m_BackLeftMotor);
    m_RightMotors = new MotorControllerGroup(m_FrontRightMotor, m_BackRightMotor);
    m_DifferentialDrive = new DifferentialDrive(m_LeftMotors, m_RightMotors);

  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

  public DifferentialDrive getDifferentialDrive()
  {
    return m_DifferentialDrive;
  }

  public void my_InvertDrive(boolean invert) 
  {
    if (invert) {
        invertDrive = true;
    } else {
        invertDrive = false;
    }
  }

  public void my_ArcadeDrive(double speed, double rotation) 
  {
    if (invertDrive) 
    {
        m_DifferentialDrive.arcadeDrive(-speed, rotation);
    } else 
    {
        m_DifferentialDrive.arcadeDrive(speed, rotation);
    }
  }

  // find the average value between the front right and front left encoder. returns native encoder values
  public double getDistancePosition()
  {
    return (m_FrontLeftMotor.getSelectedSensorPosition() + m_FrontRightMotor.getSelectedSensorPosition()) / 2;
  }

  //if this returns a wrong value, refer to commentd out line of code for direction. What we did is we measured the distance 
  //the robot thought it went with how far it actually went and then scaled it to match. 
  public double getDistancePositionInMeters()
  {
      double motorRotations = getDistancePosition() / DriveTrainConstants.kCountsPerRev;
      double wheelRotations = motorRotations / DriveTrainConstants.kGearRatio;
      double positionInches = wheelRotations * (2 * Math.PI * DriveTrainConstants.kWheelRadiusInches);
      // return positionInches / 0.6839;
      return positionInches;
 

  }

  public void resetEncoder(){
    m_FrontLeftMotor.setSelectedSensorPosition(0);
    m_FrontRightMotor.setSelectedSensorPosition(0);
}

//getter methods for when you add a gyro

// public double getHeading() {
//     return gyro.getAngle();

// }

// public void resetGyro() { 
//     gyro.reset();
// }


}
