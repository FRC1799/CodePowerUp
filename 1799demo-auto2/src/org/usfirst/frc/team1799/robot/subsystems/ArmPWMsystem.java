package org.usfirst.frc.team1799.robot.subsystems;

import org.usfirst.frc.team1799.robot.RobotMap;
import org.usfirst.frc.team1799.robot.commands.ArmStop;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArmPWMsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

//	private Victor m_leftMotor = new Victor(RobotMap.PWM.pwm4);
//	private Victor m_rightMotor = new Victor(RobotMap.PWM.pwm5);
	private Spark m_leftMotor; 
	private Spark m_rightMotor;

	public static final double kupSpeed = -0.4; // -1 to 1 //  -0.83
	public static final double kdownSpeed = 0.4;// -1 to 1  //  0.3
	
	private DifferentialDrive mydrive;
	
	/**
	 * negative 0, 1
	 * positive 2, 3 
	 */
	//private SpeedControllerGroup m_ArmMotors = new SpeedControllerGroup(m_leftMotor,m_rightMotor);
	
	public ArmPWMsystem() {

		m_leftMotor = new Spark(RobotMap.PWM.pwm4);
		m_rightMotor = new Spark(RobotMap.PWM.pwm5);
		
		m_leftMotor.setInverted(false);
		m_rightMotor.setInverted(false);
		
		mydrive = new DifferentialDrive(m_leftMotor,m_rightMotor);
		
//		addChild("Arm Motors",m_ArmMotors)
		addChild("Arm LEFT Motors",(Spark)m_leftMotor);
		addChild("Arm RIGHT Motors",(Spark)m_rightMotor);

//		m_leftMotor.setInverted(RobotMap.leftmotorInverted);
//		m_rightMotor.setInverted(RobotMap.rightmotorInverted);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ArmStop());
    }
    

	public void stop() {
		mydrive.tankDrive(0, 0);
//		m_leftMotor.set(0);
//		m_rightMotor.set(0);
	}
	

	public void moveUp() {
//		m_leftMotor.setInverted(Robot.m_oi.getInvertLeftLiftMotor());
//		m_rightMotor.setInverted(Robot.m_oi.getInvertRightLiftMotor());

		mydrive.tankDrive(kupSpeed, kupSpeed);
		
//		m_leftMotor.set(RobotMap.kArmSpeedUp);
//		m_rightMotor.set(RobotMap.kArmSpeedUp);
	}
	

	public void moveDown() {

		mydrive.tankDrive(kdownSpeed, kdownSpeed);
//		
//		m_leftMotor.set(RobotMap.kArmSpeedDown);
//		m_rightMotor.set(RobotMap.kArmSpeedDown);
	}
	
	public void sendInfo() {
		SmartDashboard.putData(this);
		
	}
}

