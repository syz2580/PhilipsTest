package com.showeasy.philiptest.philips;

import com.showeasy.philiptest.framework.listener.NotifyListener;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 * API封装，应用中所有关于Philips Hue的操作都直接从这里调用
 */

public interface IHue {

    public enum BulbState{
        OPEN,
        CLOSE,
        UNKNOWN
        //...可能会有更多灯泡状态
    }

    public void searchBridge();

    public void connectBridge(String ip, String username);

    public void disconnectAll();

    /**
     * 获取所有灯泡状态
     * @return
     */
    public void getAllBulbState(NotifyListener callback);

    /**
     * 开灯
     * @param id 灯泡id
     * @return 返回开启是否成功
     */
    public void turnOnBulb(int id, NotifyListener callback);

    /**
     * 关灯
     * @param id 灯泡id
     * @return 返回关闭是否成功
     */
    public void turnOffBulb(int id, NotifyListener callback);

    /**
     * 获取灯泡状态
     * @param id
     * @return
     */
    public void getBulbState(int id, NotifyListener callback);

    /**
     * 设置灯泡颜色
     * @param id
     * @param color
     * @return
     */
    public void setBulbColor(int id, int color, NotifyListener callback);

    /**
     * 设置灯泡亮度
     * @param id
     * @param lumi
     * @return
     */
    public void setBulbLumi(int id, int lumi, NotifyListener callback);

}
