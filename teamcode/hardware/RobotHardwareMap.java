package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

public class RobotHardwareMap {
    //defines de variables for the motors and servos that will be used
    public DcMotor FR;
    public DcMotor FL;
    public DcMotor BR;
    public DcMotor BL;
    public DcMotor intake;
    public DcMotor handle;
    public Servo piston;
    public Servo airplane;
    public IMU imu;
    public TfodProcessor tfod;
    public VisionPortal visionPortal;
    String TFOD_MODEL_ASSET = "CenterStage.tflite";
    String[] LABELS = {
            "Pixel",
    };

    public void initializeHardware(HardwareMap hardwareMap){

        //assign each motor with the correspondent port in control hub
        FR = hardwareMap.get(DcMotor.class, "front_right");
        FL = hardwareMap.get(DcMotor.class, "front_left");
        BR = hardwareMap.get(DcMotor.class, "back_right");
        BL = hardwareMap.get(DcMotor.class, "back_left");
        intake = hardwareMap.get(DcMotor.class, "in_take");
        handle = hardwareMap.get(DcMotor.class, "handler");
        piston = hardwareMap.get(Servo.class, "out_take");
        airplane = hardwareMap.get(Servo.class, "S1");


        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        //initialize the imu
        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
            RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
            RevHubOrientationOnRobot.UsbFacingDirection.UP
        ));
        imu.initialize(parameters);


        //initialize vision
        tfod = new TfodProcessor.Builder()
                .setModelAssetName(TFOD_MODEL_ASSET)

                .setModelLabels(LABELS)
                .setIsModelTensorFlow2(true)
                .setIsModelQuantized(true)
                .setModelInputSize(300)
                .setModelAspectRatio(16.0 / 9.0)

                .build();
        VisionPortal.Builder builder = new VisionPortal.Builder();
        builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        builder.addProcessor(tfod);
        visionPortal = builder.build();
    }

}
