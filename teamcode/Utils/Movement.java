package org.firstinspires.ftc.teamcode.Utils;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.hardware.RobotHardwareMap;

public class Movement {
    RobotHardwareMap robot = new RobotHardwareMap();
    Telemetry telemetry;
    Encoders encoders = new Encoders();

    public Movement(){}
    public Movement(Telemetry telemetry){
        this.telemetry = telemetry;
    }

    public void Move(float leftSickY, float leftStickX, float rightStickX, boolean CentricMovement, double maxPower){
        double yaw = robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        telemetry.addLine(Double.toString(yaw));
        double y, x;

        if (CentricMovement){
            x = leftStickX * Math.cos(-yaw) - leftSickY * Math.sin(-yaw);
            y = leftStickX * Math.sin(-yaw) + leftSickY * Math.cos(-yaw);
        }
        else {
            x = leftStickX;
            y = leftSickY;
        }

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rightStickX), 1);
        double frontLeftPower = (y + x + rightStickX) / denominator * maxPower;
        double backLeftPower = (y - x + rightStickX) / denominator * maxPower;
        double frontRightPower = (y - x - rightStickX) / denominator * maxPower;
        double backRightPower = (y + x - rightStickX) / denominator * maxPower;

        robot.FR.setPower(frontRightPower);
        robot.FL.setPower(frontLeftPower);
        robot.BR.setPower(backRightPower);
        robot.BL.setPower(backLeftPower);

        telemetry.addLine(Double.toString(frontRightPower));
        telemetry.addLine(Double.toString(frontLeftPower));
        telemetry.addLine(Double.toString(backLeftPower));
        telemetry.addLine(Double.toString(backRightPower));
        telemetry.update();
    }

    public void MoveWithAngle(float angle, float rotation, double power){

        double leftStickX = Math.sin((angle * Math.PI) / 180);
        double leftSickY = Math.cos((angle * Math.PI) / 180);
        double yaw = robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double y, x;

        x = leftStickX * Math.cos(-yaw) - leftSickY * Math.sin(-yaw);
        y = leftStickX * Math.sin(-yaw) + leftSickY * Math.cos(-yaw);

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rotation), 1);
        double frontLeftPower = (y + x + rotation) / denominator * power;
        double backLeftPower = (y - x + rotation) / denominator * power;
        double frontRightPower = (y - x - rotation) / denominator * power;
        double backRightPower = (y + x - rotation) / denominator * power;

        telemetry.addLine(Double.toString(frontRightPower));
        telemetry.addLine(Double.toString(frontLeftPower));
        telemetry.addLine(Double.toString(backRightPower));
        telemetry.addLine(Double.toString(backLeftPower));

        telemetry.update();


        robot.FR.setPower(frontRightPower);
        robot.FL.setPower(frontLeftPower);
        robot.BR.setPower(backRightPower);
        robot.BL.setPower(backLeftPower);
    }
}
