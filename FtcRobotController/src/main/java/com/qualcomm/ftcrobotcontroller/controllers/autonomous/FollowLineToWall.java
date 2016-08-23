package com.qualcomm.ftcrobotcontroller.controllers.autonomous;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.neurons.Cardinal;
import com.qualcomm.ftcrobotcontroller.neurons.Distance;
import com.qualcomm.ftcrobotcontroller.organs.DriveTrain;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.lib.AdafruitColor;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TColor;
import com.qualcomm.robotcore.hardware.ColorSensor;
/**
 * Created by shaash on 8/23/16.
 */
public class FollowLineToWall implements Controller{
    private DriveTrain TwoWheelDriveTrain;
    private Instruments instruments;
    private TColor color;
    public FollowLineToWall(DriveTrain dt, Instruments i) {
        TwoWheelDriveTrain = dt;
        instruments = i;

    }
    public boolean tick() {
        if(Distance.isAtWall(instruments.distance)) {
            while(instruments.yaw<90){
                TwoWheelDriveTrain.drive(0.5f,0f);
            }
            TwoWheelDriveTrain.stop();
        }
        else {

            if(color.red()>200){
                TwoWheelDriveTrain.drive(0.3f, 0.5f);

            } else {
                TwoWheelDriveTrain.drive(0.5f, 0.3f);
            }
        }
        return Distance.isAtWall(instruments.distance);
    }
}
