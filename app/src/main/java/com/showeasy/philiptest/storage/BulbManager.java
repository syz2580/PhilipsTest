package com.showeasy.philiptest.storage;

import com.showeasy.philiptest.storage.entity.Bulb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 * 存储与管理灯泡信息
 */

public class BulbManager {

    /**
     * 灯泡列表
     */
    private List<Bulb> mBulbList;

    private static class BulbManagerHolder {
        private static final BulbManager instance = new BulbManager();
    }
    public BulbManager getInstance() {
        return BulbManagerHolder.instance;
    }

    private BulbManager() {
        // TODO: 2016/10/31
    }

    public List<Bulb> getBulbList() {
        return mBulbList;
    }

    public void setBulbList(List<Bulb> bulbList) {
        mBulbList = bulbList;
    }

    public Bulb getBulb(String id) {
        for (Bulb b : mBulbList) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        return null;
    }
}
