package com.example.mydemo.activity;

import android.app.ActionBar;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mydemo.R;
import com.example.mydemo.util.Config;

import cn.com.video.venvy.param.JjVideoRelativeLayout;
import cn.com.video.venvy.param.JjVideoView;
import cn.com.video.venvy.param.OnJjCompletionListener;
import cn.com.video.venvy.param.VideoJjMediaContoller;

public class VideoPlayActivity extends AppCompatActivity {

    private JjVideoView video_plus;
    private static final int VIDEO_FROM=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
        setContentView(R.layout.activity_video_play);


        initView();

        init();

    }


    private void initView(){
        video_plus = (JjVideoView)findViewById(R.id.video_plus);
    }

    private void init() {
        video_plus.setVideoJjAppKey(Config.VideoPlus_Api);//配置key
        video_plus.setVideoJjPageName(Config.Package_name);//配置项目包名
        video_plus.setResourceVideo(Config.Video_Url);//开启播放
        video_plus.setVideoJjType(VIDEO_FROM);
        video_plus.setVideoJjTitle("这是个测试");

        //这个方法的作用产生控制器 很重要
        video_plus.setMediaController(new VideoJjMediaContoller(this, true));


    }






}
