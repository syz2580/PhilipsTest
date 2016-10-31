package com.showeasy.philiptest.philips;

import com.showeasy.philiptest.storage.entity.Bulb;

import java.util.List;

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

    /**
     * 获取所有灯泡状态
     * @return
     */
    public List<Bulb> getAllBulbState();

    /**
     * 开灯
     * @param id 灯泡id
     * @return 返回开启是否成功
     */
    public boolean turnOnBulb(int id);

    /**
     * 关灯
     * @param id 灯泡id
     * @return 返回关闭是否成功
     */
    public boolean turnOffBulb(int id);

    /**
     * 获取灯泡状态
     * @param id
     * @return
     */
    public BulbState getBulbState(int id);

    /**
     * 设置灯泡颜色
     * @param id
     * @param color
     * @return
     */
    public boolean setBulbColor(int id, int color);

    /**
     * 设置灯泡亮度
     * @param id
     * @param lumi
     * @return
     */
    public boolean setBulbLumi(int id, int lumi);

}
