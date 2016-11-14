package com.showeasy.philiptest.util;

import android.content.Context;
import android.content.Intent;

import com.showeasy.philiptest.activity.LightControlActivity;
import com.showeasy.philiptest.activity.LoginActivity;
import com.showeasy.philiptest.activity.MainActivity;
import com.showeasy.philiptest.activity.RegisterActivity;
import com.showeasy.philiptest.activity.TabActivity;

/**
 * Created by 邵一哲_Native on 2016/11/6.
 */

public class LaunchUtil {
    public static void launchLightControlActivity(Context context) {
        Intent intent = new Intent(context, LightControlActivity.class);
        context.startActivity(intent);
    }
    public static void launchLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
    public static void launchRegisterActivity(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }
    public static void launchMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
    public static void launchTabActivity(Context context) {
        Intent intent = new Intent(context, TabActivity.class);
        context.startActivity(intent);
    }
}
