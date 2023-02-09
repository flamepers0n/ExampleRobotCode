// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pneumatic;

public class DoubleSolenoidForward extends CommandBase {
  private final Pneumatic m_Pneumatic;
  private final DoubleSolenoid m_DoubleSolenoid;

  public DoubleSolenoidForward(Pneumatic pneumatic) {
    m_Pneumatic = pneumatic;
    addRequirements(m_Pneumatic);
    m_DoubleSolenoid = m_Pneumatic.getDoubleSolenoidPCM();

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_DoubleSolenoid.set(Value.kForward);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DoubleSolenoid.set(Value.kOff);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}