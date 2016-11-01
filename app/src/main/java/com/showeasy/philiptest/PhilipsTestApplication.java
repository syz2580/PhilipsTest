package com.showeasy.philiptest;

import android.app.Application;

import com.showeasy.philiptest.util.MiscUtil;

/**
 * Created by 邵一哲_Native on 2016/11/1.
 */

public class PhilipsTestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MiscUtil.setApplicationContext(this);
    }
}
