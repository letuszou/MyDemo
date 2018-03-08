package com.panda.demogathers.activity.bofang;

import android.view.WindowManager;
import com.panda.demogathers.R;
import com.panda.demogathers.activity.BaseActivity;
import com.panda.demogathers.util.Config;
import com.panda.demogathers.util.NetUtils;
import cn.com.video.venvy.param.JjVideoView;
import cn.com.video.venvy.param.VideoJjMediaContoller;

public class VideoPlayActivity extends BaseActivity {

    private JjVideoView video_plus;
    private static final int VIDEO_FROM=3;

    @Override
    protected void initLayoutView() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);// 去掉信息栏
        setContentView(R.layout.activity_video_play);

    }

    @Override
    protected void initView(){
        video_plus = (JjVideoView)findViewById(R.id.video_plus);
    }

    @Override
    protected void init() {
        NetUtils.isWifiConnected(this);
        video_plus.setVideoJjAppKey(Config.VideoPlus_Api);//配置key
        //获得app包名
        String pkName = VideoPlayActivity.this.getPackageName();
        video_plus.setVideoJjPageName(pkName);//配置项目包名
        video_plus.setResourceVideo(Config.Video_Url);//开启播放
        video_plus.setVideoJjType(VIDEO_FROM);
        video_plus.setVideoJjTitle("这是个测试");
        //这个方法的作用产生控制器 很重要
        video_plus.setMediaController(new VideoJjMediaContoller(this, true));
    }


    //这个是基于video++的SDK
}
