package org.firstinspires.ftc.teamcode.Utils;

import org.firstinspires.ftc.teamcode.hardware.RobotHardwareMap;

public class Dron {
    RobotHardwareMap robot = new RobotHardwareMap();
    public void throwAirplane(boolean accionButton){
        if (accionButton){
            robot.airplane.setPosition(.25);
        } else {
            robot.airplane.setPosition(0);
        }
    }
}
