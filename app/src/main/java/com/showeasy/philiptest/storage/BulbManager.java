package com.showeasy.philiptest.storage;

import com.philips.lighting.model.PHLight;
import com.showeasy.philiptest.philips.ILight;
import com.showeasy.philiptest.philips.internal.HueManager;
import com.showeasy.philiptest.storage.entity.Bulb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 * UI层存储与管理灯泡信息
 */

public class BulbManager {

    /**
     * 灯泡列表
     */
    private Map<String, Bulb> mBulbList;

    private ILight mLightManager;

    private static class BulbManagerHolder {
        private static final BulbManager instance = new BulbManager();
    }
    public BulbManager getInstance() {
        return BulbManagerHolder.instance;
    }

    private BulbManager() {
        // TODO: 2016/10/31
        mLightManager = HueManager.getInstance();
    }

    public Map<String, Bulb> getmBulbList() {
        return mBulbList;
    }

    public void setmBulbList(Map<String, Bulb> mBulbList) {
        this.mBulbList = mBulbList;
    }

    public Bulb getBulb(String id) {
        return mBulbList.get(id);
    }
}
