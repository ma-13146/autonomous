package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class MotorDistance {
    private double lastPlace;
    private DcMotor motorDistance;

    public MotorDistance(DcMotor dcMotor) {
        this.motorDistance = dcMotor;
        this.lastPlace = motorDistance.getCurrentPosition();
    }

    public double getDistance () {
        double distance = this.motorDistance.getCurrentPosition() - this.lastPlace;
        return distance;
    }
}



