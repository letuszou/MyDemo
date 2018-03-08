package com.panda.demogathers.activity;

import android.content.Intent;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void initLayoutView() {

    }

    @Override
    protected void init(){
        startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
        finish();

    }

}
