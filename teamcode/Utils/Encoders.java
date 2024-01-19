package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.hardware.RobotHardwareMap;

public class Encoders {
    RobotHardwareMap robot = new RobotHardwareMap();
    //assigns the needed data
    static double TICKSPERREVOLUTION = 537.7;
    static double WHEELDIAMETER = 96;

    int encoderSavedPositionFR = 0;
    int encoderSavedPositionFL = 0;
    int encoderSavedPositionBR = 0;
    int encoderSavedPositionBL = 0;

    //Returns the amount of ticks needed for the correspondent distance
    public int TicksByDistance(double distanceInMeters){
        double circunference = Math.PI * WHEELDIAMETER * 1000;
        double TotalRevolutions = distanceInMeters / circunference;
        long TotalTicks = Math.round(TotalRevolutions / TICKSPERREVOLUTION);
        return (int)TotalTicks;
    }

    public void initializeEncoders(){
        //Set all the motor encoders to cero
        robot.FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.handle.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //change the motors RunMode to use encoders
        robot.FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.handle.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
