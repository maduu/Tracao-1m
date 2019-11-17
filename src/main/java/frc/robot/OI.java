package frc.robot;

import frc.robot.subsystems.SubsystemJoystick;
import frc.robot.commands.*;
import frc.robot.Robot;

public class OI {
    public OI(){
        Robot.joystick.whenPressed(SubsystemJoystick.d_X, new CommandForward());
        Robot.joystick.whenPressed(SubsystemJoystick.d_Y, new CommandBackward());
    }
}