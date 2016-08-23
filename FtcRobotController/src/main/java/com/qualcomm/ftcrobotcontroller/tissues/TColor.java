package com.qualcomm.ftcrobotcontroller.tissues;

import com.qualcomm.ftcrobotcontroller.debug.Component;
import com.qualcomm.ftcrobotcontroller.debug.Logger;
import com.qualcomm.ftcrobotcontroller.lib.AdafruitColor;
import com.qualcomm.ftcrobotcontroller.statics.Hardware;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * Created by max on 4/17/16.
 */
public class TColor implements Component {
    private AdafruitColor colorsensor;

    public String getName(){return "Color";}

    private int offsetRed, offsetGreen, offsetBlue, offsetAlpha;
    private int threshold = 50;

    public enum Color {
        RED, BLUE, WHITE, NONE
    }

    public TColor(String c) {
        colorsensor = new AdafruitColor(Hardware.getHardwareMap(), c);
        this.calibrate();
    }

    /**
     * Sets gain
     * @param gain
     */
    public void setGain(int gain) { colorsensor.setGain(gain); }

    /**
     * Sets the integration time
     * @param ms
     */
    public void setIntegration(double ms) { colorsensor.setIntegrationTime(ms); }

    /**
     * Gets the red of the color sensor
     * @return red value read by the color sensor
     */
    public int red() {
        return Math.abs(colorsensor.redColor() - offsetRed);
    }

    /**
     * Gets the green of the color sensor
     * @return green value read by the color sensor
     */
    public int green() {
        return Math.abs(colorsensor.greenColor() - offsetGreen);
    }

    /**
     * Gets the blue of the color sensor
     * @return blue value read by the color sensor
     */
    public int blue() {
        return Math.abs(colorsensor.blueColor() - offsetBlue);
    }

    /**
     * Gets the alpha of the color sensor
     * @return alpha value read by the color sensor
     */
    public int alpha() {
        return Math.abs(colorsensor.clearColor() - offsetAlpha);
    }

    /**
     * Sets the threshold of the color sensor.
     * @param t threshhold to be set
     */
    public void setThreshold(int t) {
        threshold = t;
    }

    /**
     * Calibrates the color sensor.
     */
    public void calibrate() {
        offsetRed = colorsensor.redColor();
        offsetGreen = colorsensor.greenColor();
        offsetBlue = colorsensor.blueColor();
        offsetAlpha = colorsensor.clearColor();
    }
    public Boolean test() {
        Logger.logLine("r:" + this.red() + " g:" + this.green() + " b:" + this.blue());
        return true;
    }
}
