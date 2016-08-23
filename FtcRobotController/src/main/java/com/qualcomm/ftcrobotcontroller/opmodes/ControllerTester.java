package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.AccStickDrive;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.GimbalBumpers;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.GridDrive;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.OneStickDrive;
import com.qualcomm.ftcrobotcontroller.controllers.tests.ButtonTest;
import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.organs.Gimbal;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.organs.QuadDrivetrain;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;

import java.util.ArrayList;

/**
 * Created by Admin on 4/19/2016.
 *
 * Tests tick-based controllers.
 */
public class ControllerTester extends T10Opmode {
    private ArrayList<Controller> tests = new ArrayList<Controller>();

    public void run()  {
        //add organs here
        TreadDrivetrain tdt = new TreadDrivetrain();
        Instruments instruments = new Instruments();
        instruments.start();
        Gimbal gimbal = new Gimbal();

        //add controllers here
        tests.add(new AccStickDrive(tdt));
        tests.add(new GimbalBumpers(gimbal));
        tests.add(new ButtonTest("^A1"));
    }

    public void tick() {
        for(int i=0; i<tests.size(); i++) {
            tests.get(i).tick();
        }
    }
}