package org.firstinspires.ftc.teamcode.Utils;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Movement {
    RobotHardwareMap robot = new RobotHardwareMap();
    Encoders encoders = new Encoders();

    public void Move(float leftSickY, float leftStickX, float rightStickX, boolean CentricMovement){
        double yaw = robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double y, x;
        leftSickY *= -1;
        if (CentricMovement){
            x = leftStickX * Math.cos(-yaw) - leftSickY * Math.sin(-yaw);
            y = leftStickX * Math.sin(-yaw) + leftSickY * Math.cos(-yaw);
        }
        else {
            x = leftStickX;
            y = leftSickY;
        }

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rightStickX), 1);
        double frontLeftPower = (y + x + rightStickX) / denominator;
        double backLeftPower = (y - x + rightStickX) / denominator;
        double frontRightPower = (y - x - rightStickX) / denominator;
        double backRightPower = (y + x - rightStickX) / denominator;

        robot.FR.setPower(frontRightPower);
        robot.FL.setPower(frontLeftPower);
        robot.BR.setPower(backRightPower);
        robot.BL.setPower(backLeftPower);
    }

    public void MoveWithAngle(float angle, float rotation, int forward, double distanceInMeters){

        float leftStickX = angle / 90;
        float leftSickY = (90 - leftStickX) * forward;
        double yaw = robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double y, x;
        leftSickY *= -1;

        x = leftStickX * Math.cos(-yaw) - leftSickY * Math.sin(-yaw);
        y = leftStickX * Math.sin(-yaw) + leftSickY * Math.cos(-yaw);

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rotation), 1);
        double frontLeftPower = (y + x + rotation) / denominator;
        double backLeftPower = (y - x + rotation) / denominator;
        double frontRightPower = (y - x - rotation) / denominator;
        double backRightPower = (y + x - rotation) / denominator;

        int ticks = encoders.TicksByDistance(distanceInMeters);

        robot.FR.setTargetPosition(ticks);
        robot.FL.setTargetPosition(ticks);
        robot.BR.setTargetPosition(ticks);
        robot.BL.setTargetPosition(ticks);

        robot.FR.setPower(frontRightPower);
        robot.FL.setPower(frontLeftPower);
        robot.BR.setPower(backRightPower);
        robot.BL.setPower(backLeftPower);
    }
}
