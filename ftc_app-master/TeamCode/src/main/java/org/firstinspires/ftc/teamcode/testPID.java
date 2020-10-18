package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="testPID", group="Iterative Opmode")

public class testPID extends OpMode {
    private DcMotor leftMotor=null;
    private DcMotor rightMotor= null;
    private pid PID;


    public void init() {
        //leftMotor = hardwareMap.get(DcMotor.class, "left_drive");
        rightMotor = hardwareMap.get(DcMotor.class, "right_drive");
        //leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        PID = new pid(0.9,1,1,0);
        PID.set_set_point(10000);

        PID= new pid(0.9,1,1,0);
        PID.set_set_point(1);


    }

    public void init_loop() {
    }

    public void start() {
    }

    public void loop() {
        if (PID.tolorance_boolen(1000, 1000) == false) {
            rightMotor.setPower(PID.cal(rightMotor.getCurrentPosition()));
        }
        else {
            rightMotor.setPower(0);
        }

        telemetry.addData("right_motor", "encoder: " + rightMotor.getCurrentPosition());


    }

    public void stop() {

    }

}
