package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotHardwareAndreTest {
    //naming all the Dc Motors and assigning them into a variable
    public static DcMotor test;
    public static Servo open;
    public static DcMotor move;
    public void initializeHardware(HardwareMap hardwareMap){
        //Assigning the class and name of each DcMotor
        test = hardwareMap.get(DcMotor.class, "0");
        open = hardwareMap.get(Servo.class, "S0");
        move = hardwareMap.get(DcMotor.class, "1");
    }
}
