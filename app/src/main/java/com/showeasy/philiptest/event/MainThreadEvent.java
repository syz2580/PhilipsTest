package com.showeasy.philiptest.event;

/**
 * Created by 邵一哲_Native on 2016/11/2.
 */

public class MainThreadEvent {
    protected int code;

    protected Object data;

    protected int type;

    public MainThreadEvent() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
