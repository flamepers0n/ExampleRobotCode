// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.TankDrive;

public class TankWithJoystick extends CommandBase {
  /** Creates a new TankWithJoysticlk. */
  private final TankDrive m_TankDriveSubsystem;
  private final DifferentialDrive m_TankDrive;
  private final XboxController m_DriveController;
  public TankWithJoystick(XboxController driveController, TankDrive tankDrive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_TankDriveSubsystem = tankDrive;
    addRequirements(m_TankDriveSubsystem);
    m_TankDrive = m_TankDriveSubsystem.getDifferentialDrive();
    m_DriveController = driveController;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_TankDrive.tankDrive(m_DriveController.getLeftY(), m_DriveController.getRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_TankDrive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
