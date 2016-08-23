package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.ArrayList;

/**
 * Created by Admin on 4/19/2016.
 *
 * Sequential autonomous controller-ticker
 */
public abstract class T10Autonomous extends OpMode {
    private ArrayList<Controller> queue = new ArrayList<Controller>(); //must be fixed so we can call .tick() on any static controller

    private int index = 0;

    public final void init() {
        initStatics();
        registration();
    }

    public final void initStatics() {
        Hardware.init(hardwareMap);
        Logger.init(telemetry);
    }

    public final void loop() {
        if(index < queue.size()) {
            boolean complete = queue.get(index).tick();

            if(complete) {
                Logger.logLine("Task complete: " + index);
                index++;
            }
        }
    }

    /**
    * Called by the child to register a controller into the queueing system
    */
    public final void registerController(Controller ctrl) {
        queue.add(ctrl);
    }

    /**
     * A place for autonomous opmodes to register their controllers
     */
    public abstract void registration();
}
