package com.qualcomm.ftcrobotcontroller.statics;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by robotics on 4/14/16.
 */
public class Hardware {
    public static DcMotor MotorLeftRear, MotorRightRear, MotorLeftFront, MotorRightFront,
        GimbalHorizontal, GimbalVertical;

    public static Servo ServoTop;

    public static String IMU, Color;

    public static AnalogInput Ultra;

    private static HardwareMap hardwareMap;

    public static HardwareMap getHardwareMap() { return hardwareMap; }

    public static void init(HardwareMap h) {
        hardwareMap = h;

        MotorLeftRear = hardwareMap.dcMotor.get("m1");
        MotorRightRear = hardwareMap.dcMotor.get("m2");
        MotorLeftFront = hardwareMap.dcMotor.get("m3");
        MotorRightFront = hardwareMap.dcMotor.get("m4");

        GimbalHorizontal = hardwareMap.dcMotor.get("m5");
        GimbalVertical = hardwareMap.dcMotor.get("m6");

        ServoTop = hardwareMap.servo.get("s1");

        IMU = "g1";
        Color = "c1";
        Ultra = hardwareMap.analogInput.get("u1");
    }
}
