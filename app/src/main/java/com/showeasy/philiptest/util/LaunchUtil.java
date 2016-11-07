package com.showeasy.philiptest.util;

import android.content.Context;
import android.content.Intent;

import com.showeasy.philiptest.activity.LightControlActivity;

/**
 * Created by 邵一哲_Native on 2016/11/6.
 */

public class LaunchUtil {
    public static void launchLightControlActivity(Context context) {
        Intent intent = new Intent(context, LightControlActivity.class);
        context.startActivity(intent);
    }
}
