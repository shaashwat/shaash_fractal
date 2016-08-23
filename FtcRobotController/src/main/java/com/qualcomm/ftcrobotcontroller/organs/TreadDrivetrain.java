package com.qualcomm.ftcrobotcontroller.organs;

import com.qualcomm.robotcore.util.Range;

import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.ftcrobotcontroller.tissues.TMotor;

/**
 * Created by max on 4/17/16.
 */
public class TreadDrivetrain extends DriveTrain {
    private TMotor leftRear, leftFront, rightRear, rightFront;
    public String getName() {return "Tread Drivetrain";}
    public TreadDrivetrain() {
        leftRear = new TMotor(Hardware.MotorLeftRear);
        leftFront = new TMotor(Hardware.MotorLeftFront);
        rightRear = new TMotor(Hardware.MotorRightRear);
        rightFront = new TMotor(Hardware.MotorRightFront);
        rightFront.setDirection(false);
        rightRear.setDirection(false);
    }

    /**
     * Drives using all four motors
     * @param lF left front motor
     * @param lR left rear motor
     * @param rF right front motor
     * @param rR right rear motor
     * */
    public void driveQuad(float lR, float lF, float rR, float rF) {
        leftRear.move(lR);
        leftFront.move(lF);
        rightRear.move(rR);
        rightFront.move(rF);
    }

    public void drive(float left, float right) {
        right = (float)Range.clip(right, -1.0, 1.0);
        left = (float)Range.clip(left, -1.0, 1.0);

        this.driveQuad(left, left, right, right);
    }
}
