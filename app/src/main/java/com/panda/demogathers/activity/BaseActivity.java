package com.panda.demogathers.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.umeng.analytics.MobclickAgent;


public abstract class BaseActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayoutView();
        initView();
        init();
        initUrl();
        initData();
    }


    protected abstract void initLayoutView();

    protected void initView() {

    }

    protected void init() {
    }

    protected void initUrl() {
    }

    protected void initData() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


}
