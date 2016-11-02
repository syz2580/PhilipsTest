package com.showeasy.philiptest.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by 邵一哲_Native on 2016/7/25.
 */
public class DisplayUtil {
    private static int screenWidth = 0;
    private static int screenHeight = 0;

    public static int dip2px(Context context, float dipValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }
    public static int px2dip(Context context, float pxValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }
    //获取屏幕的宽度
    public static int getScreenWidth(Context context) {
        if (screenWidth == 0) {
            WindowManager manager = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point p = new Point();
            display.getSize(p);
            screenWidth = p.x;
            screenHeight = p.y;
        }
        return screenWidth;
    }
    //获取屏幕的高度
    public static int getScreenHeight(Context context) {
        if (screenHeight == 0) {
            WindowManager manager = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point p = new Point();
            display.getSize(p);
            screenWidth = p.x;
            screenHeight = p.y;
        }
        return screenHeight;
    }
}