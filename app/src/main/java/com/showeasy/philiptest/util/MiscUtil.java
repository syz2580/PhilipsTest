package com.showeasy.philiptest.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 邵一哲_Native on 2016/11/1.
 */

public class MiscUtil {

    private static Context applicationContext;

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(Context applicationContext) {
        MiscUtil.applicationContext = applicationContext;
    }

    public static void showToast(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_LONG).show();
    }
}
