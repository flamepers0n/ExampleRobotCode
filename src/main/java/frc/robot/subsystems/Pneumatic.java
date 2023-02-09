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
  private final Compressor pcmCompressor; 
  private final Compressor phCompressor; 
  private final DoubleSolenoid DoublePCM;
  private final DoubleSolenoid DoublePH;
  public Pneumatic(int moduleNumber, int forwardSolenoidChannel, int reverseSolenoidChannel) {
      phCompressor = new Compressor(moduleNumber, PneumaticsModuleType.REVPH); // for use witht the REV Robotics Pneumatics Hub
      DoublePH  = new DoubleSolenoid(moduleNumber, PneumaticsModuleType.REVPH, forwardSolenoidChannel, reverseSolenoidChannel); //PH Double Solenoid

      pcmCompressor = new Compressor(moduleNumber, PneumaticsModuleType.CTREPCM); //for use with the CTRE Pneumatics Control Module
      DoublePCM = new DoubleSolenoid(moduleNumber, PneumaticsModuleType.CTREPCM, forwardSolenoidChannel, reverseSolenoidChannel); //PCM Double Solenoid  
  
   


    pcmCompressor.enableDigital(); //automatically compresses when pressure is low 
    //pcmCompressor.enableAnalog(0, 0); //enables the compressor when pressure is below min and disables when at max
    pcmCompressor.disable(); //disables the compressor

    phCompressor.enableDigital();
    phCompressor.disable();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public Compressor getCompressorPCM(){
    return pcmCompressor;
  }
  public Compressor getCompressorPH(){
    return phCompressor;
  }

  public DoubleSolenoid getDoubleSolenoidPCM(){
    return DoublePCM;
  }
  public DoubleSolenoid getDoubleSolenoidPH()
  {
    return DoublePH;
  }
}