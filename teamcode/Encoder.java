package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_USING_ENCODER;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;

//312 RPM
//537.7  pulsos por revoluciòn
//301.6mm por revoluciòn
//0.56090756927654826111214431839316mm per pulse(tick)
//1.7828249336870026525198938992042 ticks per mm
//.83777777777777777777777777777778 degrees per mm
public class Encoder {
    //imports the RobotHarwareClass and assigns it to a new variable mame robot
    RobotHardwareAndre robot = new RobotHardwareAndre();

    //creates a new variable that defines the degrees that the robot need to rotate for move 1mm
    public static final double TICKS_PER_REV = 537.7;
    public static final double MAX_RPM = 312;

    public void InitializeEncoders(){
        robot.BR.setMode(RUN_USING_ENCODER);
        robot.FR.setMode(RUN_USING_ENCODER);
        robot.FL.setMode(RUN_USING_ENCODER);
        robot.BL.setMode(RUN_USING_ENCODER);
    }
    public void moveForward(float distance, float power){
        robot.BR.setTargetPosition(5);
        robot.BR.setMode(RUN_TO_POSITION);
    }
}
