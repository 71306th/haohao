// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  
  private final WPI_TalonSRX leftfront;
  private final WPI_TalonSRX leftrear;
  private final WPI_TalonSRX rightfront;
  private final WPI_TalonSRX rightrear;

  private final MotorControllerGroup left ;
  private final MotorControllerGroup right ;

  private final DifferentialDrive drive;



  /** Creates a new ExampleSubsystem. */
  public Chassis() {
    leftfront = new WPI_TalonSRX(Constants.Chassis.LFMotor);
    leftrear = new WPI_TalonSRX(Constants.Chassis.LRMotor);
    rightfront = new WPI_TalonSRX(Constants.Chassis.RFMotor);
    rightrear = new WPI_TalonSRX(Constants.Chassis.RRMotor);

    left = new MotorControllerGroup(leftfront, leftrear);
    right = new MotorControllerGroup(rightfront, rightrear);

    drive = new DifferentialDrive(left, right);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void arcadeDrive(double speed, double turn){
    drive.arcadeDrive(-speed, turn);
  }
}
