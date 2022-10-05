// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ShootWthJoystick;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private static final XboxController driverController = new XboxController(0);
  private final Shooter m_shooter = new Shooter();

  private final Shoot m_autoCommand = new Shoot(m_shooter);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_shooter.setDefaultCommand(new ShootWthJoystick(m_shooter, () -> driverController.getLeftY()));
    // Configure the button bindings
    configureButtonBindings();


  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * @param throttle 
   */
  private void configureButtonBindings() {
    new JoystickButton(driverController, XboxController.Button.kRightBumper.value).whileHeld(new Shoot(m_shooter));
    //new JoystickButton(driverController, XboxController.Axis.kLeftY.value).whileHeld(new ShootWithJoystick(m_shooter, () -> driverController.getLeftY()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
