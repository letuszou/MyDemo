package com.panda.demogathers.activity.time;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.panda.demogathers.R;
import com.panda.demogathers.service.RegisterCodeTimerService;
import com.panda.demogathers.util.RegisterCodeTimer;

public class SendCodeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_code_sixty;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_code);
        initView();
        init();
        setListener();
    }

    private void initView() {
        tv_code_sixty = (TextView) findViewById(R.id.tv_code_sixty);
    }

    private void init() {
        RegisterCodeTimerService.setHandler(mCodeHandler);
        mIntent = new Intent(SendCodeActivity.this, RegisterCodeTimerService.class);
    }

    private void setListener() {
        tv_code_sixty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_code_sixty:
                codeSix();
                break;
        }
    }

    private void codeSix() {
        tv_code_sixty.setEnabled(false);
        startService(mIntent);
    }

    /**
     * 倒计时Handler
     */
    @SuppressLint("HandlerLeak")
    Handler mCodeHandler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == RegisterCodeTimer.IN_RUNNING) {// 正在倒计时
                tv_code_sixty.setText(msg.obj.toString());
            } else if (msg.what == RegisterCodeTimer.END_RUNNING) {// 完成倒计时
                tv_code_sixty.setEnabled(true);
                tv_code_sixty.setText(msg.obj.toString());
            }
        }
    };

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        stopService(mIntent);
    }


}
