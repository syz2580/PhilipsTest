package com.showeasy.philiptest.philips.internal;

import android.os.Build;

import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;
import com.showeasy.philiptest.framework.listener.NotifyListener;
import com.showeasy.philiptest.philips.IHue;
import com.showeasy.philiptest.philips.ILight;
import com.showeasy.philiptest.storage.entity.Bulb;

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

    private static class HueManagerHolder {
        private static final HueManager instance = new HueManager();
    }
    public static HueManager getInstance() {
        return HueManagerHolder.instance;
    }
    private HueManager() {
        // TODO: 2016/10/31 初始化操作
        phHueSDK = PHHueSDK.create();
        phHueSDK.setAppName("PhilipTest");
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
    public void setBulbColor(int id, int color, NotifyListener callback) {
        boolean result = false;
        // TODO: 2016/11/1
        PHBridge bridge = phHueSDK.getSelectedBridge();
        PHLightState lightState = new PHLightState();
        lightState.setHue(12345);
        PHLight light;

        callback.onNotify(result);
    }

    @Override
    public void setBulbLumi(int id, int lumi, NotifyListener callback) {
        boolean result = false;
        // TODO: 2016/11/1
        callback.onNotify(result);
    }

    @Override
    public Map<String, Bulb> getAllBulbs() {
        mCache = phHueSDK.getSelectedBridge().getResourceCache();
        List<PHLight> lights = mCache.getAllLights();
        mBulbs = new HashMap<>();
        for (PHLight light : lights) {
            PHLightState state = light.getLastKnownLightState();
            Bulb bulb = new Bulb.Builder()
                    .id(light.getUniqueId()) //这个id应该是应用确定的id，但目前应用还没定下来，id规则无法设计
                    .color(state.getHue())
                    .lumi(state.getBrightness())
                    .turnOn(state.isOn())
                    .build();
            mBulbs.put(light.getUniqueId(), bulb);
        }
        return mBulbs;
    }

    @Override
    public Bulb getBulb(String id) {
        return mBulbs.get(id);
    }
}
