package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
    public static Servo airplane;
    public static IMU imu;

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
    }
}
