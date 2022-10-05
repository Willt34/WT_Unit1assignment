// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private static final int leftMotorid=61;
  private static final int rightMotorid=62;

  private CANSparkMax leftMotor = new CANSparkMax(leftMotorid, MotorType.kBrushless);
  private CANSparkMax rightMotor = new CANSparkMax(rightMotorid, MotorType.kBrushless);
  private double speed;
  private double voltage;
  public Shooter() {

    REVPhysicsSim.getInstance().addSparkMax(leftMotor, DCMotor.getNeo550(1));
    REVPhysicsSim.getInstance().addSparkMax(rightMotor, DCMotor.getNeo550(1));
    speed = 0.0;
    voltage = 0.0;

    leftMotor.setInverted(true);

    //Shooter.setInverted(RightMotor, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    leftMotor.set(speed);
    rightMotor.set(speed);
    System.out.println(speed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    leftMotor.setVoltage(voltage);
    rightMotor.setVoltage(voltage);
  }

  public void setJoystickSpeed(double throttle){
    speed = throttle;
    voltage = speed*12;
    System.out.println(throttle);
  }

  public void setMotorSpeed() {
    speed = 0.5;
    voltage = speed*12;
  }

  public void stopMotor() {
    speed = 0.0;
    speed = 0.0;
    voltage = speed;
  }
}