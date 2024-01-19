package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Utils.Encoders;
import org.firstinspires.ftc.teamcode.Utils.IntakeOutake;
import org.firstinspires.ftc.teamcode.Utils.Movement;
import org.firstinspires.ftc.teamcode.Utils.Vision;
import org.firstinspires.ftc.teamcode.hardware.RobotHardwareMap;

@Autonomous(name = "Red")
public class AutonomusRed extends LinearOpMode {

    Encoders encoders = new Encoders();
    Movement movement = new Movement(telemetry);
    IntakeOutake intakeOutake = new IntakeOutake();
    RobotHardwareMap robotHardwareMap = new RobotHardwareMap();

    public void runOpMode(){
        Vision vision = new Vision(telemetry);

        waitForStart();
        while (opModeIsActive()) {
            robotHardwareMap.initializeHardware(hardwareMap);

            vision.telemetryTfod();

            // Push telemetry to the Driver Station.
            telemetry.update();

            // Save CPU resources; can resume streaming when needed.
            if (gamepad1.dpad_down) {
                robotHardwareMap.visionPortal.stopStreaming();
            } else if (gamepad1.dpad_up) {
                robotHardwareMap.visionPortal.resumeStreaming();
            }

            // Share the CPU.
            sleep(20);
        }
        robotHardwareMap.visionPortal.close();
    }
}
