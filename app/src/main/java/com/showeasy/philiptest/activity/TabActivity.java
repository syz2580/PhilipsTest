package com.showeasy.philiptest.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.showeasy.philiptest.R;
import com.showeasy.philiptest.fragment.ChatFragment;
import com.showeasy.philiptest.fragment.LightControlFragment;
import com.showeasy.philiptest.fragment.MeFragment;

public class TabActivity extends BaseActivity {

    private final static int LIGHT_CONTROL_FRAGMENT = 0;
    private final static int CHAT_FRAGMENT = 1;
    private final static int ME_FRAGMENT = 2;

    private LinearLayout mVgTabMenuLight;
    private LinearLayout mVgTabMenuChat;
    private LinearLayout mVgTabMenuMe;
    private TextView mTvTabMenuLight;
    private TextView mTvTabMenuChat;
    private TextView mTvTabMenuMe;

    private FragmentManager mFragmentManager;

    private LightControlFragment lightControlFragment;
    private ChatFragment chatFragment;
    private MeFragment meFragment;

    private int mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        initViews();

        lightControlFragment = new LightControlFragment();
        chatFragment = new ChatFragment();
        meFragment = new MeFragment();

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .add(R.id.content, lightControlFragment)
                .commit();
    }

    private void initViews() {
        mVgTabMenuLight = (LinearLayout) findViewById(R.id.ly_tab_menu_light);
        mVgTabMenuChat = (LinearLayout) findViewById(R.id.ly_tab_menu_chat);
        mVgTabMenuMe = (LinearLayout) findViewById(R.id.ly_tab_menu_me);

        mTvTabMenuLight = (TextView) findViewById(R.id.tab_menu_light);
        mTvTabMenuChat = (TextView) findViewById(R.id.tab_menu_chat);
        mTvTabMenuMe = (TextView) findViewById(R.id.tab_menu_me);

        mVgTabMenuLight.setOnClickListener(mTabMenuOnClickListener);
        mVgTabMenuChat.setOnClickListener(mTabMenuOnClickListener);
        mVgTabMenuMe.setOnClickListener(mTabMenuOnClickListener);

        mTvTabMenuLight.setSelected(true);
    }

    private void resetMenuSelected() {
        mTvTabMenuLight.setSelected(false);
        mTvTabMenuChat.setSelected(false);
        mTvTabMenuMe.setSelected(false);
    }

    private View.OnClickListener mTabMenuOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ly_tab_menu_light:
                    resetMenuSelected();
                    mTvTabMenuLight.setSelected(true);
                    mFragmentManager.beginTransaction()
                            .replace(R.id.content, lightControlFragment)
                            .commit();
                    break;
                case R.id.ly_tab_menu_chat:
                    resetMenuSelected();
                    mTvTabMenuChat.setSelected(true);
                    mFragmentManager.beginTransaction()
                            .replace(R.id.content, chatFragment)
                            .commit();
                    break;
                case R.id.ly_tab_menu_me:
                    resetMenuSelected();
                    mTvTabMenuMe.setSelected(true);
                    mFragmentManager.beginTransaction()
                            .replace(R.id.content, meFragment)
                            .commit();
                    break;
            }
        }
    };
}
