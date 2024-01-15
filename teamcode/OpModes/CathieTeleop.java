package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Utils.Encoders;
import org.firstinspires.ftc.teamcode.Utils.IntakeOutake;
import org.firstinspires.ftc.teamcode.Utils.Movement;

@TeleOp(name="CathieTeleop")
public class CathieTeleop extends LinearOpMode {
    Movement movement = new Movement();
    Encoders encoders = new Encoders();
    IntakeOutake intakeOutake = new IntakeOutake();
    public void runOpMode(){
        while (opModeIsActive()){
            movement.Move(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad2.right_stick_x, true);
            intakeOutake.IntakeAndOutake(gamepad1.a, gamepad2.left_stick_y, gamepad2.left_bumper, gamepad2.right_bumper);
            encoders.AutoAlign(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);


        }

    }
}
