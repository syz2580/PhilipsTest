package com.showeasy.philiptest.philips;

import com.showeasy.philiptest.storage.entity.Bulb;

import java.util.List;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 * 与Hue Java/Android SDK对接
 */

public class HueManager implements IHue {

    private static class HueManagerHolder {
        private static final HueManager instance = new HueManager();
    }
    public static HueManager getInstance() {
        return HueManagerHolder.instance;
    }
    private HueManager() {
        // TODO: 2016/10/31 初始化操作
    }

    @Override
    public List<Bulb> getAllBulbState() {
        // TODO: 2016/10/31
        return null;
    }

    @Override
    public boolean turnOnBulb(int id) {
        // TODO: 2016/10/31
        return false;
    }

    @Override
    public boolean turnOffBulb(int id) {
        // TODO: 2016/10/31
        return false;
    }

    @Override
    public BulbState getBulbState(int id) {
        // TODO: 2016/10/31  
        return null;
    }

    @Override
    public boolean setBulbColor(int id, int color) {
        return false;
    }

    @Override
    public boolean setBulbLumi(int id, int lumi) {
        return false;
    }


}
