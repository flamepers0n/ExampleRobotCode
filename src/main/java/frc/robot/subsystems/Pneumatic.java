// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatic extends SubsystemBase {
  /** Creates a new Pneumatic. */
  private final Compressor phCompressor; 
  private final DoubleSolenoid DoublePH;
  public Pneumatic(int moduleNumber, int forwardSolenoidChannel, int reverseSolenoidChannel) {
    phCompressor = new Compressor(moduleNumber, PneumaticsModuleType.REVPH); // for use witht the REV Robotics Pneumatics Hub
    DoublePH  = new DoubleSolenoid(moduleNumber, PneumaticsModuleType.REVPH, forwardSolenoidChannel, reverseSolenoidChannel); //PH Double Solenoid
    
     //dont konw if digital mode works or not, if things dont go to play try analog version
     //phCompressor.enableAnalog(110, 120);

    phCompressor.enableDigital();
    phCompressor.disable();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Compressor getCompressorPH(){
    return phCompressor;
  }

  public DoubleSolenoid getDoubleSolenoidPH()
  {
    return DoublePH;
  }
}