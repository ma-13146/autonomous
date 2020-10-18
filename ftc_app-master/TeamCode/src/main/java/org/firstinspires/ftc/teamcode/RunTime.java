package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class RunTime {
    private double last_run_time;
    private ElapsedTime runtime = new ElapsedTime();

    public RunTime(){
        this.last_run_time = runtime.time();
    }

    public double time(){
        double delta_time = this.runtime.time() - this.last_run_time;
        this.last_run_time = this.runtime.time();
        return delta_time;
    }
}
