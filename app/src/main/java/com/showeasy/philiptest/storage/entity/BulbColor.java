package com.showeasy.philiptest.storage.entity;

/**
 * Created by 邵一哲_Native on 2016/11/6.
 */

public class BulbColor {
    int hue;
    float x = -1,y = -1;
    int brightness;
    int rgb;

    public int getHue() {

        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getRgb() {
        return rgb;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }

    public void calculateRgb() {
        float z = 1.0f - x - y;
        float Y = brightness / 255.0f; // Brightness of lamp
        float X = (Y / y) * x;
        float Z = (Y / y) * z;
        double r =  X * 1.656492f - Y * 0.354851f - Z * 0.255038f;
        double g = -X * 0.707196f + Y * 1.655397f + Z * 0.036152f;
        double b =  X * 0.051713f - Y * 0.121364f + Z * 1.011530f;
        r = r <= 0.0031308 ? 12.92 * r : (1.0 + 0.055) * Math.pow(r, (1.0 / 2.4)) - 0.055;
        g = g <= 0.0031308 ? 12.92 * g : (1.0 + 0.055) * Math.pow(g, (1.0 / 2.4)) - 0.055;
        b = b <= 0.0031308 ? 12.92 * b : (1.0 + 0.055) * Math.pow(b, (1.0 / 2.4)) - 0.055;
        double maxValue = Math.max(r,Math.max(g,b));
        r /= maxValue;
        g /= maxValue;
        b /= maxValue;
        r = r * 255;   if (r < 0) { r = 255; }
        g = g * 255;   if (g < 0) { g = 255; }
        b = b * 255;   if (b < 0) { b = 255; }

        rgb = ((int)r << 16) + ((int)g << 8) + (int)b;
    }
}
