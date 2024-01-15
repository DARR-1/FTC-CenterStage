package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.robotcore.hardware.DcMotor;

public class IntakeOutake {
    RobotHardwareMap robot = new RobotHardwareMap();
    public void IntakeAndOutake(boolean a, double leftStickY, boolean leftBumper, boolean rightBumper){

        int m;

        if (leftStickY > 0){
            robot.handle.setTargetPosition(1440);
        } else {
            robot.handle.setTargetPosition(0);
        }
        robot.handle.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.handle.setPower(1);
        if (leftBumper){
            robot.piston.setPosition(.5);
        } else {
            robot.piston.setPosition(0);
        }
        if (rightBumper){
            m = -1;
        } else {
            m = 1;
        }
        if (a){
            robot.intake.setPower(.9 * m);
        } else {
            robot.intake.setPower(0);
        }
    }
}
