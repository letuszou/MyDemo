package com.panda.demogathers.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.panda.demogathers.R;
import com.panda.demogathers.update.UpdateJson;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_expand;
    private TextView tv_pdf_read;
    private TextView tv_about;
    private TextView tv_video_play;
    private TextView tv_audio_play;
    private TextView tv_recycler;
    private TextView tv_send_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();

    }

    private void initView() {
        tv_about = (TextView) findViewById(R.id.tv_about);
        tv_expand = (TextView) findViewById(R.id.tv_expand);
        tv_pdf_read = (TextView) findViewById(R.id.tv_pdf_read);
        tv_video_play = (TextView) findViewById(R.id.tv_video_play);
        tv_audio_play = (TextView) findViewById(R.id.tv_audio_play);
        tv_recycler = (TextView) findViewById(R.id.tv_recycler);
        tv_send_code = (TextView) findViewById(R.id.tv_send_code);
        initListener();
    }

    private void initListener() {
        tv_about.setOnClickListener(this);
        tv_expand.setOnClickListener(this);
        tv_pdf_read.setOnClickListener(this);
        tv_video_play.setOnClickListener(this);
        tv_audio_play.setOnClickListener(this);
        tv_recycler.setOnClickListener(this);
        tv_send_code.setOnClickListener(this);
        update();
    }

    private void update() {
        UpdateJson update = new UpdateJson(HomeActivity.this);
        update.getUpdate();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_about:
                startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                break;
            case R.id.tv_expand:
                startActivity(new Intent(HomeActivity.this, ExpandableListviewActivity.class));
                break;
            case R.id.tv_pdf_read:
                startActivity(new Intent(HomeActivity.this, PdfviewActivity.class));
                break;
            case R.id.tv_video_play:
                startActivity(new Intent(HomeActivity.this, VideoPlayActivity.class));
                break;
            case R.id.tv_audio_play:
                startActivity(new Intent(HomeActivity.this, AudioPlayActivity.class));
                break;
            case R.id.tv_recycler:
                startActivity(new Intent(HomeActivity.this, RecyclerActivity.class));
                break;
            case R.id.tv_send_code:
                startActivity(new Intent(HomeActivity.this, SendCodeActivity.class));
                break;

        }

    }


}
