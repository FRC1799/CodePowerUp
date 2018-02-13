/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1799.robot;

import org.usfirst.frc.team1799.robot.commands.AutoDriveForward;
import org.usfirst.frc.team1799.robot.commands.AutoDriveBack;
import org.usfirst.frc.team1799.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1799.robot.commands.CompressorToggle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * 
 * The operator interface of the robot, it has been simplified from the real
 * robot to allow control with a single PS3 joystick. 
 *
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.

	Joystick m_stick = new Joystick( RobotMap.kJoystickChannel );

	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	
	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public OI() {
		// Put Some buttons on the SmartDashboard
		SmartDashboard.putData("Drive Forward", new AutoDriveForward());
		SmartDashboard.putData("Drive Platform", new AutoDriveBack());
		

//		// Create some buttons
//		JoystickButton dpadUp = new JoystickButton(m_stick, 5);
//		JoystickButton dpadRight = new JoystickButton(m_stick, 6);
//		JoystickButton dpadDown = new JoystickButton(m_stick, 7);
//		JoystickButton dpadLeft = new JoystickButton(m_stick, 8);

		// toggle compressor on/off - for testing and demo mostly
		// TODO: try different button number
		JoystickButton dcompressor = new JoystickButton(m_stick, 7);
		dcompressor.whenPressed(new CompressorToggle());

		//TODO: un-comment  below line and see if you this in SmartDashboard.
		//SmartDashboard.putData("Compressor Toggle", new CompressorToggle());
//
//		// Connect the buttons to commands
//		dpadUp.whenPressed(new AutoDriveForward());
//		dpadDown.whenPressed(new AutoDriveBack());
	}
	
	public Joystick getJoystick() {
		return m_stick;
	}
}
