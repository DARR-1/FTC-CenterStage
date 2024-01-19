package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Utils.Encoders;
import org.firstinspires.ftc.teamcode.Utils.IntakeOutake;
import org.firstinspires.ftc.teamcode.Utils.Movement;
import org.firstinspires.ftc.teamcode.hardware.RobotHardwareMap;

@Autonomous(name = "Red")
public class AutonomusRed extends LinearOpMode {
    public void runOpMode(){

        Encoders encoders = new Encoders();
        Movement movement = new Movement(telemetry);
        IntakeOutake intakeOutake = new IntakeOutake();
        RobotHardwareMap robotHardwareMap = new RobotHardwareMap();

        waitForStart();
        robotHardwareMap.initializeHardware(hardwareMap);

        //maximum 90 grades. For left grades use negative grade and for backward ones use negative power
        movement.MoveWithAngle(45,0,1);
        sleep(1000);
        movement.MoveWithAngle(0,0,0);
    }
}
