package com.example.mydemogather.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mydemogather.R;
import com.example.mydemogather.util.Config;

import java.util.List;

public class GoogleRefreshActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout srl_google_refresh;





    private android.os.Handler mHandler = new android.os.Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case Config.REFRESH_COMPLETE:
                    srl_google_refresh.setRefreshing(false);
                    Toast.makeText(GoogleRefreshActivity.this,"刷新获取更多数据",Toast.LENGTH_SHORT).show();
                    //getMoreData();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_refresh);

        initView();

        initData();

    }

    private void initView(){
        srl_google_refresh = (SwipeRefreshLayout)findViewById(R.id.srl_google_refresh);
        srl_google_refresh.setOnRefreshListener(GoogleRefreshActivity.this);
        srl_google_refresh.setColorScheme(getResources().getColor(android.R.color.holo_blue_bright), getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light), getResources().getColor(android.R.color.holo_red_light));
    }

    private void initData(){
        //实例化获取第一批数据
    }

    @Override
    public void onRefresh() {
        mHandler.removeMessages(Config.REFRESH_COMPLETE);
        mHandler.sendEmptyMessageDelayed(Config.REFRESH_COMPLETE, 2000);
    }
}
