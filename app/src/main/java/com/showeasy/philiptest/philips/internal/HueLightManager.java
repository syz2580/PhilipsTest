package com.showeasy.philiptest.philips.internal;

import com.showeasy.philiptest.philips.ILight;
import com.showeasy.philiptest.storage.entity.Bulb;

import java.util.Map;

/**
 * Created by 邵一哲_Native on 2016/11/2.
 */

public class HueLightManager implements ILight {

    public HueLightManager() {

    }

    @Override
    public Map<String, Bulb> getAllBulbs() {
        return null;
    }

    @Override
    public Bulb getBulb(String id) {
        return null;
    }
}
