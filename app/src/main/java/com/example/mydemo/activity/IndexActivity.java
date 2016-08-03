package com.example.mydemo.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.mydemo.R;

public class IndexActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_expand;
    private TextView tv_pdf_read;
    private TextView tv_about;
    private TextView tv_video_play;
    private TextView tv_audio_play;

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

    }


    private void initListener(){
        tv_about.setOnClickListener(this);
        tv_expand.setOnClickListener(this);
        tv_pdf_read.setOnClickListener(this);
        tv_video_play.setOnClickListener(this);
        tv_audio_play.setOnClickListener(this);

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


        }

    }
}
