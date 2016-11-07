package com.showeasy.philiptest.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.philips.lighting.hue.sdk.utilities.PHUtilities;
import com.showeasy.philiptest.R;
import com.showeasy.philiptest.context.Constants;
import com.showeasy.philiptest.event.HomeEvent;
import com.showeasy.philiptest.framework.listener.NotifyListener;
import com.showeasy.philiptest.philips.ILight;
import com.showeasy.philiptest.philips.internal.HueManager;
import com.showeasy.philiptest.philips.IHue;
import com.showeasy.philiptest.storage.entity.Bulb;
import com.showeasy.philiptest.util.DoubleClickExitHelper;
import com.showeasy.philiptest.util.LaunchUtil;
import com.showeasy.philiptest.util.MiscUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

public class MainActivity extends BaseActivity {

    private DoubleClickExitHelper mDoubleClickExitHelper;

    private IHue mHue;

    private ILight mLight;

    Button mBtnConnectBridge;

    Button mBtnChangeColor;

    TextView mTvBulbMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDoubleClickExitHelper = new DoubleClickExitHelper(this);

        mHue = HueManager.getInstance();
        mLight = HueManager.getInstance();

        mBtnConnectBridge = (Button) findViewById(R.id.btn_connect_bridge);
        mBtnConnectBridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHue.connectBridge(Constants.DEFAULT_IP + ":8000",Constants.DEFAULT_USER);
            }
        });

        mBtnChangeColor = (Button) findViewById(R.id.btn_change_color);
        mBtnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotifyListener callback =  new NotifyListener() {
                    @Override
                    public void onNotify(Object result) {
                        printBulbMessage();
                    }
                };
                mHue.setBulbColor(1, 0x000588, callback);
            }
        });

        mTvBulbMessage = (TextView) findViewById(R.id.tv_bulb_msg);

        findViewById(R.id.btn_light_control).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LaunchUtil.launchLightControlActivity(MainActivity.this);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return mDoubleClickExitHelper.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHue.disconnectAll();
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(HomeEvent event) {
        switch (event.getType()) {
            case HomeEvent.TYPE_BRIDGE_CONNECT:
                MiscUtil.showToast(this, "连上啦");
                mBtnConnectBridge.setEnabled(false);
                printBulbMessage();
                break;
        }
    }

    private void printBulbMessage() {

        mTvBulbMessage.post(new Runnable() {
            @Override
            public void run() {
                String str = mLight.getAllBulbs().toString();
                mTvBulbMessage.setText(str);
            }
        });

    }
}
