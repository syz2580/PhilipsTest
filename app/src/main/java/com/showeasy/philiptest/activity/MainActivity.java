package com.showeasy.philiptest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.showeasy.philiptest.R;
import com.showeasy.philiptest.philips.internal.HueManager;
import com.showeasy.philiptest.philips.IHue;

public class MainActivity extends AppCompatActivity {

    private IHue mHue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHue = HueManager.getInstance();
    }
}
