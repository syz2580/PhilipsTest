package com.showeasy.philiptest.storage.entity;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 */

public class Bulb {
    /** 序号 */
    private String id;
    /** 亮度 */
    private int lumi;
    /** 颜色 */
    private int color;
    /** 开关状态 */
    private boolean isTurnOn;

    public Bulb(String id, int lumi, int color, boolean isTurnOn) {
        this.id = id;
        this.lumi = lumi;
        this.color = color;
        this.isTurnOn = isTurnOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLumi() {
        return lumi;
    }

    public void setLumi(int lumi) {
        this.lumi = lumi;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isTurnOn() {
        return isTurnOn;
    }

    public void setTurnOn(boolean turnOn) {
        isTurnOn = turnOn;
    }
}
