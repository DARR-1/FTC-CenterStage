package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class RobotHardwareAndre {
    //naming all the Dc Motors and assigning them into a variable
    public static DcMotor FR;
    public static DcMotor FL;
    public static DcMotor BR;
    public static DcMotor BL;
    public static DcMotor intake;
    public static Servo open;
    public static DcMotor move;
    public IMU imu;
    public void initializeHardware(HardwareMap hardwareMap){
        //Assigning the class and name of each DcMotor
        FR = hardwareMap.get(DcMotor.class, "2");
        FL = hardwareMap.get(DcMotor.class, "0");
        BR = hardwareMap.get(DcMotor.class, "1");
        BL = hardwareMap.get(DcMotor.class, "3");
        intake = hardwareMap.get(DcMotor.class, "4");
        open = hardwareMap.get(Servo.class, "S0");
        move = hardwareMap.get(DcMotor.class, "5");
        BR.setDirection(DcMotor.Direction.REVERSE);
        FR.setDirection(DcMotor.Direction.REVERSE);
        move.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

}
