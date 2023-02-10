// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands;
import java.util.function.Supplier;

import javax.xml.crypto.dsig.SignedInfo;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class ArcadeWithJoy extends CommandBase {

     private final DriveTrain m_DriveTrain;
     private Supplier driveSpeedSupplier;
     private Supplier turningSpeedSupplier;

    public ArcadeWithJoy(DriveTrain m_DriveTrain, Supplier DriveSpeedSupplier, Supplier turningSpeedSupplier) 
    {
        this.m_DriveTrain = m_DriveTrain;
        this.driveSpeedSupplier = driveSpeedSupplier;
        this.turningSpeedSupplier = turningSpeedSupplier;
        addRequirements(m_DriveTrain);
        
        
}

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
     
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() 
    {   
        double driveSpeed = (double)driveSpeedSupplier.get();
        double turningSpeed = (double)turningSpeedSupplier.get();

        m_DriveTrain.my_ArcadeDrive(driveSpeed, turningSpeed);

       
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_DriveTrain.getDifferentialDrive().arcadeDrive(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() 
    {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() 
    {
        return false;
    }
}