package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.ftcrobotcontroller.controllers.Controller;
import com.qualcomm.ftcrobotcontroller.controllers.autonomous.FollowLineToWall;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.AccStickDrive;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.GimbalBumpers;
import com.qualcomm.ftcrobotcontroller.controllers.teleop.RickshawController;
import com.qualcomm.ftcrobotcontroller.controllers.tests.ButtonTest;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.organs.Gimbal;
import com.qualcomm.ftcrobotcontroller.organs.Instruments;
import com.qualcomm.ftcrobotcontroller.organs.RickshawDrivetrain;
import com.qualcomm.ftcrobotcontroller.organs.TreadDrivetrain;
import com.qualcomm.ftcrobotcontroller.organs.TwoWheelDriveTrain;
import com.qualcomm.ftcrobotcontroller.statics.ControlParser;
import com.qualcomm.ftcrobotcontroller.statics.Controls;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by shaash on 8/23/16.
 */
public class LineFollowWall extends T10Opmode{
    private FollowLineToWall linefollow;
    public void run()  {
        //add organs here
        TwoWheelDriveTrain drivetrain = new TwoWheelDriveTrain();
        Instruments instruments = new Instruments();
        instruments.start();

        //add controllers here
        FollowLineToWall linefollow = new FollowLineToWall(drivetrain, instruments);

    }
    public void tick(){
        linefollow.tick();
    }

}
