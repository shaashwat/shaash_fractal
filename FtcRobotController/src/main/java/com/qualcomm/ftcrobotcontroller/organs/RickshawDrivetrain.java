package com.qualcomm.ftcrobotcontroller.organs;
import android.os.PowerManager;

import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TMotor;
import com.qualcomm.ftcrobotcontroller.tissues.TServo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by shaash on 8/22/16.
 */
public class RickshawDrivetrain extends DriveTrain {
    private TMotor backLeftWheel, backRightWheel;
    private TServo frontSteerWheel;
    public RickshawDrivetrain() {
        backLeftWheel = new TMotor(Hardware.MotorLeftRear);
        backRightWheel = new TMotor(Hardware.MotorRightRear);
        frontSteerWheel = new TServo(Hardware.ServoTop);
    }
    public void drive(float left, float right){
        left = Range.clip(left, -1.0f, 1.0f);
        right = Range.clip(right, -1.0f, 1.0f);
        float power;
        if (left > 0 || right > 0){
            power = .5f;
        } else if (left<0 || right < 0){
            power = -.5f;
        } else {
            power = 0;
        }
        float steer;
        if (right >0 && left > 0){
            steer = right-left;
        } else {
            steer = 0;
        }
        backLeftWheel.move(power);
        backRightWheel.move(power);
        frontSteerWheel.moveTo(steer);
    }

}
