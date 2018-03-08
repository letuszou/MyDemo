package com.panda.demogathers.activity.time;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.panda.demogathers.R;
import com.panda.demogathers.activity.BaseActivity;

public class TimeAboutActivity extends BaseActivity {


    @Override
    protected void initLayoutView() {
        setContentView(R.layout.activity_time_about);
    }

    @Override
    protected void init() {
        findViewById(R.id.about_tv_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TimeAboutActivity.this,SendCodeActivity.class));
            }
        });
    }
}
