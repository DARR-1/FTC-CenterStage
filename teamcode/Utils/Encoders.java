package org.firstinspires.ftc.teamcode.Utils;

import com.qualcomm.robotcore.hardware.DcMotor;

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
    public void AutoAlign(double x, double y, double z){
        if (Math.abs(x) + Math.abs(y) + Math.abs(z) > 0){
            encoderSavedPositionFR = robot.FR.getCurrentPosition();
            encoderSavedPositionFR = robot.FL.getCurrentPosition();
            encoderSavedPositionFR = robot.BR.getCurrentPosition();
            encoderSavedPositionFR = robot.BL.getCurrentPosition();

        }
        robot.FR.setTargetPosition(encoderSavedPositionFR);
        robot.FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.FR.setPower(1);
        robot.FL.setTargetPosition(encoderSavedPositionFR);
        robot.FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.FL.setPower(1);
        robot.BR.setTargetPosition(encoderSavedPositionFR);
        robot.BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.BR.setPower(1);
        robot.BL.setTargetPosition(encoderSavedPositionFR);
        robot.BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.BL.setPower(1);
    }
}
