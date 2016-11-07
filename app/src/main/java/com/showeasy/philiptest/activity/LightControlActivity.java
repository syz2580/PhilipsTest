package com.showeasy.philiptest.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;

import com.showeasy.philiptest.R;
import com.showeasy.philiptest.fragment.LightControlFragment;

public class LightControlActivity extends BaseActivity {

    Fragment mFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_light_control);
        init();
    }

    private void init() {
        mFragment = new LightControlFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_light_control, mFragment);
        transaction.commit();
    }

}
