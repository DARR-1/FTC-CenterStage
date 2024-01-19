package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
public class movements {
    RobotHardwareAndre robot = new RobotHardwareAndre();
    final double COUNTS = 1000, DIAMETER = 10.16;

    public void LeftAndRight(float power) {
        //move left and right
        robot.FR.setPower(-power);
        robot.FL.setPower(power);
        robot.BR.setPower(power);
        robot.BL.setPower(-power);
    }

    public void FrontBack(float power) {
        //Move up and down
        robot.FR.setPower(power);
        robot.FL.setPower(power);
        robot.BR.setPower(power);
        robot.BL.setPower(power);
    }

    public void TurnLeftRight(float power) {
        RobotHardwareAndre.FR.setPower(power);
        RobotHardwareAndre.FL.setPower(-power);
        RobotHardwareAndre.BR.setPower(power);
        RobotHardwareAndre.BL.setPower(-power);
    }
}


//mateneme :(