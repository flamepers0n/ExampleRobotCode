// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class TankDrive extends SubsystemBase {
  /** Creates a new TankDrive. */
  private final WPI_TalonFX m_FrontLeftMotor;
  private final WPI_TalonFX m_FrontRightMotor;
  private final WPI_TalonFX m_BackLeftMotor;
  private final WPI_TalonFX m_BackRightMotor;
  private final MotorControllerGroup m_RightMotors;
  private final MotorControllerGroup m_LeftMotors;
  private final DifferentialDrive m_TankDriveTrain;

  public TankDrive() {
    m_FrontLeftMotor = new WPI_TalonFX(DriveTrainConstants.kFrontLeftCanId);  
    m_FrontRightMotor = new WPI_TalonFX(DriveTrainConstants.kFrontRightCanId);
    m_BackLeftMotor = new WPI_TalonFX(DriveTrainConstants.kBackLeftCanId);
    m_BackRightMotor = new WPI_TalonFX(DriveTrainConstants.kBackRightCanId);

    m_LeftMotors = new MotorControllerGroup(m_FrontLeftMotor, m_BackLeftMotor);
    m_RightMotors = new MotorControllerGroup(m_FrontRightMotor, m_BackRightMotor);
    m_TankDriveTrain = new DifferentialDrive(m_LeftMotors, m_RightMotors);

    m_LeftMotors.setInverted(DriveTrainConstants.kLeftInverted);
    m_RightMotors.setInverted(DriveTrainConstants.kRightInverted);
  }

  public DifferentialDrive getDifferentialDrive(){
    return m_TankDriveTrain;
  }

  @Override
  public void periodic() {
    
  }
}
