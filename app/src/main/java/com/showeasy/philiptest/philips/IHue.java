package com.showeasy.philiptest.philips;

import com.showeasy.philiptest.framework.listener.NotifyListener;

/**
 * Created by 邵一哲_Native on 2016/10/31.
 * API封装，应用中所有关于Philips Hue的操作都直接从这里调用
 */

public interface IHue {
    
    public void searchBridge();

    public void connectBridge(String ip, String username);

    public void disconnectAll();
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
