package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class pid {

    private double kp;
    private double ki;
    private double kd;
    private double F;
    private double set_point;
    private double I;
    private RunTime run_time = new RunTime();
    private double last_error;
    private double source;


    public pid (double kp, double ki, double kd, double F) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.F = F;
        this.I = 0;
        this.last_error = 0;

    }

    public void set_set_point (double set_point) {

        this.set_point = set_point;
    }

    public double cal (double source){
        this.source = source;
        double delta_time = run_time.time();
        double error = this.set_point - this.source;
        double P = error * kp;
        this.I += (error * delta_time) * ki;
        double D = ((error - this.last_error) / delta_time) * kd;
        double pid = P + this.I + D + this.F;
        if (pid >= 1){
            return 1;
        }
        else if (pid <= -1){
            return -1;
        }
        else {
            return pid;
        }
    }


    public boolean tolorance_boolen (double tolorance, int wait_time){
        if (source <= Math.abs(this.set_point + tolorance) && source >= Math.abs(this.set_point - tolorance)){
            return true;
        }
        else {
            return false;
        }

    }

}

