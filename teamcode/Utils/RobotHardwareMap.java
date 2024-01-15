package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotHardwareMap {
    //defines de variables for the motors and servos that will be used
    public static DcMotor FR;
    public static DcMotor FL;
    public static DcMotor BR;
    public static DcMotor BL;
    public static DcMotor intake;
    public static DcMotor handle;
    public static Servo piston;
    public static IMU imu;

    public void initializeHardware(HardwareMap hardwareMap){

        //assign each motor with the correspondent port in control hub
        FR = hardwareMap.get(DcMotor.class, "0");
        FL = hardwareMap.get(DcMotor.class, "2");
        BR = hardwareMap.get(DcMotor.class, "3");
        BL = hardwareMap.get(DcMotor.class, "4");
        intake = hardwareMap.get(DcMotor.class, "5");
        handle = hardwareMap.get(DcMotor.class, "6");
        piston = hardwareMap.get(Servo.class, "S0");

        //Set all the motor encoders to cero
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        handle.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //change the motors RunMode to use encoders
        FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        handle.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //initialize the imu
        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
            RevHubOrientationOnRobot.LogoFacingDirection.UP,
            RevHubOrientationOnRobot.UsbFacingDirection.UP
        ));
        imu.initialize(parameters);
    }
}
