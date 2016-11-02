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

    private Bulb() {}

    public static class Builder {
        public Bulb mBulb;
        public Builder() {
            mBulb = new Bulb();
        }
        public Builder id(String id) {
            mBulb.setId(id);
            return this;
        }
        public Builder lumi(int lumi) {
            mBulb.setLumi(lumi);
            return this;
        }
        public Builder color(int color) {
            mBulb.setColor(color);
            return this;
        }
        public Builder turnOn(boolean isTurnOn) {
            mBulb.setTurnOn(isTurnOn);
            return this;
        }
        public Bulb build() {
            return mBulb;
        }
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
