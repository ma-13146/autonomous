package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="testPowerPID", group="Iterative Opmode")

public class testPowerPID extends OpMode {
    private DcMotor leftMotor=null;
    private DcMotor rightMotor=null;
    private pid powerPID;
    private MotorDistance motorDistance = null;
    private RunTime runTime = new RunTime();

    public void init(){
        //leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        //leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motorDistance = new MotorDistance(rightMotor);

        powerPID= new pid(0.9,1,1,1);
        powerPID.set_set_point(50);
    }

    public void init_loop() {

    }


    public void start() {
    }


    public void loop() {
        double power = motorDistance.getDistance() / runTime.time();
        if (powerPID.tolorance_boolen(10, 1000) == false) {
            rightMotor.setPower(powerPID.cal(power));
        }
        else {
            rightMotor.setPower(0);
        }

        telemetry.addData("right_motor", "encoder: " + rightMotor.getPower());
    }


    public void stop() {

    }

}
