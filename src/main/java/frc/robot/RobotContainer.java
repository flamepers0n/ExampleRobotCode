// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeWithJoy;
import frc.robot.commands.DoubleSolenoidForward;
import frc.robot.commands.DoubleSolenoidReverse;
import frc.robot.commands.IntakeComsume;
import frc.robot.commands.IntakeEject;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pneumatic;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ElevatorConstants;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final XboxController m_driverController = new XboxController(OperatorConstants.kDriverControllerPort);
  private final DriveTrain m_DriveTrain = new DriveTrain();
  private final Pneumatic m_ElevatorPneumatic = new Pneumatic(ElevatorConstants.moduleNumber, ElevatorConstants.forwardSolenoidChannel, ElevatorConstants.reverseSolenoidChannel);
  private final Intake m_IntakeSubsystem = new Intake();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    m_DriveTrain.setDefaultCommand(new ArcadeWithJoy(m_DriveTrain, m_driverController::getLeftY, m_driverController::getRightX));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`



    //binds the elevator to move up when you press Y and down when you press X on the XboxController
    new JoystickButton(m_driverController, XboxController.Button.kX.value).whileTrue(new DoubleSolenoidReverse(m_ElevatorPneumatic));
    new JoystickButton(m_driverController, XboxController.Button.kY.value).whileTrue(new DoubleSolenoidForward(m_ElevatorPneumatic));
    
    new Trigger(() -> {
      if(m_driverController.getLeftTriggerAxis() > 0 || m_driverController.getLeftTriggerAxis() < 0) {
        return true;
      } else {
        return false;
      }
    } ).whileTrue(new IntakeEject(m_IntakeSubsystem, (m_driverController::getLeftTriggerAxis)));


    
    // new Trigger(() -> {
    //   if(m_driverController.getRightTriggerAxis() > 0 || m_driverController.getRightTriggerAxis() < 0) {
    //     return true;
    //   } else {
    //     return false;
    //   }
    // } ).whileTrue(new IntakeComsume(m_IntakeSubsystem, m_driverController::getRightTriggerAxis));



    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
     return new PrintCommand("fake auto");
   }
}
