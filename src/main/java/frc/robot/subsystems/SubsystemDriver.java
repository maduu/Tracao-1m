package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.CommandDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import static frc.robot.RobotMap.*;
import frc.robot.Robot;

public class SubsystemDriver extends Subsystem {
	private VictorSP motorFrontLeft = new VictorSP(DRIVE_MOTOR_FL_ID);
	private VictorSP motorRearLeft = new VictorSP(DRIVE_MOTOR_RL_ID);
	private VictorSP motorFrontRight = new VictorSP(DRIVE_MOTOR_FR_ID);
	private VictorSP motorRearRight = new VictorSP(DRIVE_MOTOR_RR_ID);

	private SpeedControllerGroup motorLeft = new SpeedControllerGroup(motorFrontLeft, motorRearLeft);
	private SpeedControllerGroup motorRight = new SpeedControllerGroup(motorFrontRight, motorRearRight);
	private DifferentialDrive driveTrain = new DifferentialDrive(motorLeft, motorRight);

	public Encoder encoderDriver = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	double pulses;

	@Override
	public void initDefaultCommand() {
		Robot.driver.setDefaultCommand(new CommandDrive());
	}

	public SubsystemDriver() {
		super();
	}

	public void tankDrive(double leftSpeed, double rightSpeed) {
		driveTrain.tankDrive(leftSpeed, rightSpeed);
	}

	public void arcadeDrive(double speed, double heading) {
		driveTrain.arcadeDrive(speed, heading);
	}

	public void driveTrainLeft(double speed) {
		this.motorLeft.set(speed);
	}

	public void driveTrainRight(double speed) {
		this.motorRight.set(speed);
	}

	public double returnPulses(){
		this.pulses = encoderDriver.get();
		return pulses;
	}
}