// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.*;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShootWthJoystick extends CommandBase {

  private final Shooter m_shooter;
  public final DoubleSupplier m_throttle;

  /** Creates a new ShootWithJoystick. */
  public ShootWthJoystick(Shooter shooter, DoubleSupplier throttle) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = shooter;
    m_throttle = throttle;


    addRequirements(shooter);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_shooter.setJoystickSpeed(m_throttle.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}