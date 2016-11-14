package com.showeasy.philiptest.philips.internal;

import android.os.Build;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.utilities.PHUtilities;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.philips.lighting.model.PHSchedule;
import com.showeasy.philiptest.R;
import com.showeasy.philiptest.framework.listener.NotifyListener;
import com.showeasy.philiptest.philips.IHue;
import com.showeasy.philiptest.philips.ILight;
import com.showeasy.philiptest.storage.entity.Bulb;
import com.showeasy.philiptest.util.ColorUtil;
import com.showeasy.philiptest.util.MiscUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 * 与Hue Java/Android SDK对接
 */

public class HueManager implements IHue, ILight {

    private PHHueSDK phHueSDK;
    private HueBridgeConnection connection;
    private PHBridgeResourcesCache mCache;
    private Map<String, Bulb> mBulbs;
    private Map<String, PHLight> mLights;

    private static class HueManagerHolder {
        private static final HueManager instance = new HueManager();
    }
    public static HueManager getInstance() {
        return HueManagerHolder.instance;
    }
    private HueManager() {
        // TODO: 2016/10/31 初始化操作
        phHueSDK = PHHueSDK.create();
        phHueSDK.setAppName(MiscUtil.getApplicationContext().getString(R.string.app_name));
        phHueSDK.setDeviceName(Build.MODEL);
        connection = new HueBridgeConnection(phHueSDK);
    }

    @Override
    public void searchBridge() {
        connection.searchBridge();
    }

    @Override
    public void connectBridge(String ip, String username) {
        connection.connectBridge(ip,username);
    }

    @Override
    public void disconnectAll() {
        connection.disconnectAll();
    }

    @Override
    public void turnOnBulb(int id, NotifyListener callback) {
        boolean result = false;
        // TODO: 2016/11/1
        callback.onNotify(result);
    }

    @Override
    public void turnOffBulb(int id, NotifyListener callback) {
        boolean result = false;
        // TODO: 2016/11/1
        callback.onNotify(result);
    }

    @Override
    public void setBulbColor(int id, int color, final NotifyListener callback) {
        // TODO: 2016/11/1
        PHLight light = mLights.get(id +"");
        PHBridge bridge = phHueSDK.getSelectedBridge();
        PHLightState lightState = new PHLightState();

        float[] xy = PHUtilities.calculateXY(color, light.getModelNumber());
        lightState.setX(xy[0]);
        lightState.setY(xy[1]);
        if (null != callback) {
            bridge.updateLightState(light, lightState, new PHLightListener() {
                @Override
                public void onReceivingLightDetails(PHLight phLight) {}
                @Override
                public void onReceivingLights(List<PHBridgeResource> list) {}
                @Override
                public void onSearchComplete() {}
                @Override
                public void onSuccess() {}
                @Override
                public void onError(int i, String s) {
                    callback.onNotify(false);
                }
                @Override
                public void onStateUpdate(Map<String, String> map, List<PHHueError> list) {
                    callback.onNotify(true);
                }
            });
        } else {
            bridge.updateLightState(light, lightState);
        }

    }

    @Override
    public void setBulbLumi(int id, int lumi, NotifyListener callback) {
        boolean result = false;
        // TODO: 2016/11/1
        callback.onNotify(result);
    }

    @Override
    public Map<String, Bulb> getAllBulbs() {
        PHBridge bridge = phHueSDK.getSelectedBridge();
        if (null == bridge) {
            return new HashMap<>();
        }
        mCache = bridge.getResourceCache();
        if (null == mCache) {
            return new HashMap<>();
        }
        List<PHLight> lights = mCache.getAllLights();
        mBulbs = new HashMap<>();
        mLights = new HashMap<>();
        for (PHLight light : lights) {
            PHLightState state = light.getLastKnownLightState();
            Bulb.Builder builder = new Bulb.Builder()
                    .id(light.getIdentifier()) //这个id应该是应用确定的id，但目前应用还没定下来，id规则无法设计
                    .lumi(state.getBrightness())
                    .turnOn(state.isOn())
                    .name("灯泡" + light.getIdentifier());

            if (state.getColorMode() == PHLight.PHLightColorMode.COLORMODE_XY) {
                builder.color(ColorUtil.XYtoRGB(state.getX(),state.getY(),state.getBrightness()));
            } else if (state.getColorMode() == PHLight.PHLightColorMode.COLORMODE_HUE_SATURATION){
                float[] hsv = new float[]{state.getHue()/65536.0f*360.0f, state.getSaturation()/254.0f, state.getBrightness()/254.0f};
                builder.color(ColorUtil.HSVToColor(hsv));
            }
            Bulb bulb = builder.build();
            mBulbs.put(light.getIdentifier(), bulb);
            mLights.put(light.getIdentifier(), light);
        }
        return mBulbs;
    }

    @Override
    public Bulb getBulb(String id) {
        return mBulbs.get(id);
    }
}
