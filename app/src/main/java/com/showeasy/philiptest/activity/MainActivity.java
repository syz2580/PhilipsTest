package com.showeasy.philiptest.activity;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.showeasy.philiptest.R;
import com.showeasy.philiptest.event.HomeEvent;
import com.showeasy.philiptest.philips.internal.HueManager;
import com.showeasy.philiptest.philips.IHue;
import com.showeasy.philiptest.util.DoubleClickExitHelper;
import com.showeasy.philiptest.util.MiscUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity {

    private DoubleClickExitHelper mDoubleClickExitHelper;

    private IHue mHue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDoubleClickExitHelper = new DoubleClickExitHelper(this);

        mHue = HueManager.getInstance();

        Button btnConnectBridge = (Button) findViewById(R.id.btn_connect_bridge);
        btnConnectBridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHue.connectBridge("10.241.12.109:8000","newdeveloper");
            }
        });

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
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(HomeEvent event) {
        switch (event.getType()) {
            case HomeEvent.TYPE_BRIDGE_CONNECT:
                MiscUtil.showToast(this, "连上啦");
                break;
        }
    }
}
