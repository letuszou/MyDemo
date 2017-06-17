package com.panda.demogathers.activity;

import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }


    private void init(){
        startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
        finish();

    }


}
