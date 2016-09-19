package com.panda.demogathers.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;
import com.panda.demogathers.R;
import com.panda.demogathers.util.Config;
import com.nostra13.universalimageloader.core.ImageLoader;

public class AudioPlayActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_auido_play_image;
    private ImageView iv_play_audio;
    private boolean isPlay;
    private RotateAnimation animation;
    private boolean isFirst;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_play);

        initView();

        setListener();

        init();


    }

    private void initView() {
        iv_auido_play_image = (ImageView) findViewById(R.id.iv_audio_play_image);
        iv_play_audio = (ImageView) findViewById(R.id.iv_play_audio);
        startRetate();
        isPlay = false;
        isFirst = true;
    }

    private void setListener() {
        iv_play_audio.setOnClickListener(this);
    }

	//注意音频播放尽量使用mp3格式 如果使用wmv格式部分手机会报错  自带的兼容性不好
    private void init() {
        ImageLoader.getInstance().displayImage(Config.Audio_Image_Url, iv_auido_play_image);
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_play_audio:
                if (isFirst) {
                    isPlay = true;
                    iv_play_audio.setImageResource(R.drawable.stop);
                    iv_auido_play_image.startAnimation(animation);
                    isFirst = false;
                    startAudio();
                } else {

                    if (isPlay) {
                        iv_play_audio.setImageResource(R.drawable.start);
                        animation.cancel();
                        isPlay = false;
                        mediaPlayer.pause();
                    } else {
                        startRetate();
                        isPlay = true;
                        iv_play_audio.setImageResource(R.drawable.stop);
                        iv_auido_play_image.startAnimation(animation);
                        mediaPlayer.start();
                    }
                }


                break;

        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isPlay) {
            animation.cancel();
            mediaPlayer.stop();
        }
    }

    private void startRetate() {
        //224s的音频
        animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(15 * 1000);//设置动画持续时间
        // /** 常用方法 */
        animation.setRepeatCount(-1);//设置重复次数
        animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        animation.setStartOffset(0);//执行前的等待时间
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin);

    }


    private void startAudio() {

        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(Config.Audio_Url);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            Toast.makeText(AudioPlayActivity.this, "播放出错", Toast.LENGTH_SHORT).show();
        }


//        try {
//            mediaPlayer.reset();
//            mediaPlayer.setDataSource(Config.Audio_Url);
//            mediaPlayer.prepare();
//            //mediaPlayer.start();
//        } catch (Exception e) {
//
//        }

    }

}
