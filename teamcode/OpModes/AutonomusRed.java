package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Utils.Encoders;
import org.firstinspires.ftc.teamcode.Utils.IntakeOutake;
import org.firstinspires.ftc.teamcode.Utils.Movement;

@Autonomous(name = "Red")
public class AutonomusRed extends LinearOpMode {
    public void runOpMode(){

        Encoders encoders = new Encoders();
        Movement movement = new Movement();
        IntakeOutake intakeOutake = new IntakeOutake();

        while (opModeIsActive()){
            movement.MoveWithAngle(45, 0, 1, .5);
        }
    }
}
