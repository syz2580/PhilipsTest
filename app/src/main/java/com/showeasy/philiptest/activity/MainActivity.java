package com.showeasy.philiptest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.showeasy.philiptest.R;
import com.showeasy.philiptest.philips.internal.HueManager;
import com.showeasy.philiptest.philips.IHue;
import com.showeasy.philiptest.util.DoubleClickExitHelper;

public class MainActivity extends BaseActivity {

    private DoubleClickExitHelper mDoubleClickExitHelper;

    private IHue mHue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDoubleClickExitHelper = new DoubleClickExitHelper(this);

        mHue = HueManager.getInstance();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return mDoubleClickExitHelper.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }
}
