package com.showeasy.philiptest.philips;

import com.showeasy.philiptest.storage.entity.Bulb;

import java.util.Map;

/**
 * Created by 邵一哲_Native on 2016/11/2.
 */

public interface ILight {
    public Map<String, Bulb> getAllBulbs();
    public Bulb getBulb(String id);
}
