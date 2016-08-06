package com.example.mydemogather.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.mydemogather.R;

public class IndexActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_expand;
    private TextView tv_pdf_read;
    private TextView tv_about;
    private TextView tv_video_play;
    private TextView tv_audio_play;
    private TextView tv_google_refresh;
    private TextView tv_actionbar_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏掉整个ActionBar，包括下面的Tabs
        setContentView(R.layout.activity_index);
        initView();
        initListener();
    }


    private void initView(){
        tv_about = (TextView)findViewById(R.id.tv_about);
        tv_expand = (TextView)findViewById(R.id.tv_expand);
        tv_pdf_read = (TextView)findViewById(R.id.tv_pdf_read);
        tv_video_play = (TextView)findViewById(R.id.tv_video_play);
        tv_audio_play = (TextView)findViewById(R.id.tv_audio_play);
        tv_google_refresh = (TextView)findViewById(R.id.tv_google_refresh);
        tv_actionbar_one = (TextView)findViewById(R.id.tv_actionbar_one);

    }


    private void initListener(){
        tv_about.setOnClickListener(this);
        tv_expand.setOnClickListener(this);
        tv_pdf_read.setOnClickListener(this);
        tv_video_play.setOnClickListener(this);
        tv_audio_play.setOnClickListener(this);
        tv_google_refresh.setOnClickListener(this);
        tv_actionbar_one.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_about:
                startActivity(new Intent(IndexActivity.this,AboutActivity.class));
                break;
            case R.id.tv_expand:
                startActivity(new Intent(IndexActivity.this,ExpandableListviewActivity.class));
                break;
            case R.id.tv_pdf_read:
                startActivity(new Intent(IndexActivity.this,PdfviewActivity.class));
                break;
            case R.id.tv_video_play:
                startActivity(new Intent(IndexActivity.this,VideoPlayActivity.class));
                break;
            case R.id.tv_audio_play:
                startActivity(new Intent(IndexActivity.this,AudioPlayActivity.class));
                break;
            case R.id.tv_google_refresh:
                startActivity(new Intent(IndexActivity.this,GoogleRefreshActivity.class));
                break;
            case R.id.tv_actionbar_one:
                startActivity(new Intent(IndexActivity.this,ActionbarOneActivity.class));
                break;

        }

    }
}
