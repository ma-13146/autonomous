package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MotorDistance {
    private double lastPlace;
    private DcMotor MotorDistance;


    public MotorDistance() {
        this.MotorDistance = null;
        this.lastPlace = MotorDistance.getCurrentPosition();
    }

    public double getDistance () {
        double distance = this.MotorDistance.getCurrentPosition() - this.lastPlace;
        return distance;
    }
}



