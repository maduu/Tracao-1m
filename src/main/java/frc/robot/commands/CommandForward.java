package frc.robot.commands;

import frc.robot.subsystems.SubsystemJoystick;
import edu.wpi.first.wpilibj.command.*;
import frc.robot.Robot;

public class CommandForward extends Command {
	private double a = 3015;
	private double pulsesCurrent;
	
	public CommandForward() {
		super(Robot.driver);
	}

	@Override
	protected void initialize() {
		Robot.driver.encoderDriver.reset();
	}

	@Override
	protected void execute() {
		Robot.driver.tankDrive(0.25, 0.25);
	}

	@Override
	protected boolean isFinished() {
		this.pulsesCurrent = Robot.driver.returnPulses();
		if (this.pulsesCurrent >= this.a) {
		return false;
		}
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted(){
		Robot.driver.tankDrive(0.0, 0.0);
	}
}
