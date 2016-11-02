package com.showeasy.philiptest.philips;

import android.os.Build;

import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.showeasy.philiptest.framework.listener.NotifyListener;
import com.showeasy.philiptest.storage.entity.Bulb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 * 与Hue Java/Android SDK对接
 */

public class HueManager implements IHue {

    private PHHueSDK phHueSDK;
    private HueBridgeConnection connection;
    private PHBridgeResourcesCache cache;

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
    public void getAllBulbState(NotifyListener callback) {
        List<Bulb> result = new ArrayList<>();
        // TODO: 2016/11/1

        cache = phHueSDK.getSelectedBridge().getResourceCache();
        cache.getAllLights();
        callback.onNotify(result);
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
    public void getBulbState(int id, NotifyListener callback) {
        Bulb result = null;
        callback.onNotify(result);
    }

    @Override
    public void setBulbColor(int id, int color, NotifyListener callback) {
        boolean result = false;
        // TODO: 2016/11/1
        PHBridge bridge = phHueSDK.getSelectedBridge();
        PHLight light;

        callback.onNotify(result);
    }

    @Override
    public void setBulbLumi(int id, int lumi, NotifyListener callback) {
        boolean result = false;
        // TODO: 2016/11/1
        callback.onNotify(result);
    }

}
