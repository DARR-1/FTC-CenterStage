package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Utils.Encoders;
import org.firstinspires.ftc.teamcode.Utils.IntakeOutake;
import org.firstinspires.ftc.teamcode.Utils.Movement;
import org.firstinspires.ftc.teamcode.Utils.Dron;
import org.firstinspires.ftc.teamcode.Utils.Vision;
import org.firstinspires.ftc.teamcode.hardware.RobotHardwareMap;

@TeleOp(name="CathieTeleop")
public class CathieTeleop extends LinearOpMode {
    Movement movement = new Movement(telemetry);
    Encoders encoders = new Encoders();
    Dron dron = new Dron();
    Vision vision = new Vision(telemetry);
    IntakeOutake intakeOutake = new IntakeOutake();
    RobotHardwareMap robot = new RobotHardwareMap();
    public void runOpMode(){
        waitForStart();
        while (opModeIsActive()){
            robot.initializeHardware(hardwareMap);
            movement.Move(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, true, 1);
            intakeOutake.IntakeAndOutake(gamepad1.a, gamepad2.left_stick_y, gamepad2.left_bumper, gamepad2.right_bumper);
            dron.throwAirplane(gamepad2.x);
        }

    }
}
