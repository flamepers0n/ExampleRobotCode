// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class DriveTrainConstants{
    public static final boolean kLeftInverted = false;
    public static final boolean kRightInverted = false;
    public static final int kFrontLeftCanId = 0;
    public static final int kFrontRightCanId = 0;
    public static final int kBackLeftCanId = 0;
    public static final int kBackRightCanId = 0;
  }
  public static class PneumaticConstants{
    
  }
  public static class IntakeConstants {
    public static final int IntakeCANID = 0; //placeholder
  }
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
