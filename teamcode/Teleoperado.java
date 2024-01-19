package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
//Our robot is named ♥♥♥cathie♥♥♥

//name the program and assigning it to th TeleOp option
@TeleOp(name="Teleoperado")
public class Teleoperado extends LinearOpMode {
    public static float distanceDash = 0;
    public static float powerDash = 0;
    //getting the RobotHardware class and assigning it into a variable
    public RobotHardwareAndre robot = new RobotHardwareAndre();

    public movements movement = new movements();


    //this variable defines the power
    @Override
    //start of opMode
    public void runOpMode(){
        //calling a function in RobotHardware
        //calling the wait for start function
        waitForStart();

        robot.initializeHardware(hardwareMap);
        //principal loop
        while(opModeIsActive()){
            telemetry.update();

            //move Front and back
            movement.FrontBack(gamepad1.left_stick_y);

            //move left and right
            movement.LeftAndRight(-gamepad1.left_stick_x);

            //turn left and right
            movement.TurnLeftRight(gamepad1.right_stick_x);

            //Controls the intake
            if (gamepad2.left_stick_y > 0.1){
                robot.move.setTargetPosition(-1350);
                telemetry.addLine("move_button_detected");
            }else {
                robot.move.setTargetPosition(0);
                telemetry.addLine("no movement detected");
            }
            robot.move.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.move.setPower(1);

            if (gamepad2.left_bumper){
                robot.open.setPosition(0.5);
            } else {
                robot.open.setPosition(-0.2);
            }

            if (gamepad2.right_bumper) {
                if (gamepad2.a) {
                    robot.intake.setPower(.9);
                } else if (gamepad2.b) {
                    robot.intake.setPower(.8);
                } else if (gamepad2.x) {
                    robot.intake.setPower(.7);
                } else if (gamepad2.y) {
                    robot.intake.setPower(.6);
                } else {
                    robot.intake.setPower(0);
                }
            } else {
                if (gamepad2.a) {
                    robot.intake.setPower(-.9);
                } else if (gamepad2.b) {
                    robot.intake.setPower(-.8);
                } else if (gamepad2.x) {
                    robot.intake.setPower(-.7);
                } else if (gamepad2.y) {
                    robot.intake.setPower(-.6);
                } else {
                    robot.intake.setPower(0);
                }
            }
        }
    }
}