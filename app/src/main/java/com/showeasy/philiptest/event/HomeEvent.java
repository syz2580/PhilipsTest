package com.showeasy.philiptest.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 邵一哲_Native on 2016/11/2.
 */

public class HomeEvent extends MainThreadEvent {
    public static final int TYPE_BRIDGE_CONNECT = 0;

    public static void post(int type, Object... data) {
        EventBus.getDefault().post(new HomeEvent(type, data));
    }

    public HomeEvent(int type, Object... data) {
        this.type = type;
        this.data = data;
    }
}
