package com.qualcomm.ftcrobotcontroller.controllers.teleop;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.neurons.Distance;
import com.qualcomm.ftcrobotcontroller.neurons.HumanDriving;
import com.qualcomm.ftcrobotcontroller.organs.DriveTrain;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;
import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.neurons.Distance;
import com.qualcomm.ftcrobotcontroller.organs.DriveTrain;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;

import java.util.ArrayList;

/**
 * Created by shaash on 8/22/16.
 */
public class RickshawController implements Controller {
    private DriveTrain drivetrain;
    private Instruments instruments;

    public RickshawController(DriveTrain dt, Instruments i) {
        drivetrain = dt;
        instruments = i;
    }

    public boolean tick() {
        ArrayList<Float> powersLeft = ControlParser.range("LS1");
        ArrayList<Float> powersRight = ControlParser.range("RS1");
        if(Distance.isAtWall(instruments.distance)) {
            drivetrain.stop();
            Logger.logLine("Help MEEEEE!");
        } else {
            drivetrain.drive(powersLeft.get(1), powersRight.get(1));
        }
        return false;
    }
}
