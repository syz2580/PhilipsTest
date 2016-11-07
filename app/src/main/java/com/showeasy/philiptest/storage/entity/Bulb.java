package com.showeasy.philiptest.storage.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 */

public class Bulb {
    /** 序号 */
    private String id;
    /** 亮度 */
    private int lumi = -1;
    /** 颜色 */
    private int color;
    /** 开关状态 */
    private boolean isTurnOn;

    /** 名字 */
    private String name;

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
        public Builder name(String name) {
            mBulb.setName(name);
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

    public boolean isTurnOn() {
        return isTurnOn;
    }

    public void setTurnOn(boolean turnOn) {
        isTurnOn = turnOn;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        try {
            json.put("id",id);
            json.put("color",color);
            json.put("lumi",lumi);
            json.put("isOn",isTurnOn);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }
}
