package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="TEST")
public class test extends LinearOpMode {
    RobotHardwareAndreTest robot = new RobotHardwareAndreTest();
    public void runOpMode(){
        robot.initializeHardware(hardwareMap);
        waitForStart();
        double i = 0;

        while(opModeIsActive()) {


            if (gamepad1.right_trigger != 0){
                robot.move.setPower(.8);
            }
            else {
                robot.move.setPower(0);
            }
            if (gamepad1.left_trigger != 0){
                robot.move.setPower(-.8);
            }
            else {
                robot.move.setPower(0);
            }

            if (gamepad1.left_bumper){
                robot.open.setPosition(0);
            } else {
                robot.open.setPosition(0.5);
            }

            if (gamepad1.right_bumper) {
                if (gamepad1.a) {
                    robot.test.setPower(.9);
                } else if (gamepad1.b) {
                    robot.test.setPower(.8);
                } else if (gamepad1.x) {
                    robot.test.setPower(.7);
                } else if (gamepad1.y) {
                    robot.test.setPower(.6);
                } else {
                    robot.test.setPower(0);
                }
            } else {
                if (gamepad1.a) {
                    robot.test.setPower(-.9);
                } else if (gamepad1.b) {
                    robot.test.setPower(-.8);
                } else if (gamepad1.x) {
                    robot.test.setPower(-.7);
                } else if (gamepad1.y) {
                    robot.test.setPower(-.6);
                } else {
                    robot.test.setPower(0);
                }
            }
        }
    }
}
