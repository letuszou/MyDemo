package com.example.mydemogather.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemogather.R;

public class ActionbarOneActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_actionbar_one_back;
    private TextView tv_actionbar_one_title;
    private TextView tv_actionbar_one_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏系统的标题栏,引入include或者merge作为标题栏
        setContentView(R.layout.activity_actionbar);

        initView();

    }

    private void initView(){
        tv_actionbar_one_back = (TextView)findViewById(R.id.tv_actionbar_one_back);
        tv_actionbar_one_title = (TextView)findViewById(R.id.tv_actionbar_one_title);
        tv_actionbar_one_share = (TextView)findViewById(R.id.tv_actionbar_one_share);

        tv_actionbar_one_back.setOnClickListener(this);
        tv_actionbar_one_share.setOnClickListener(this);
        tv_actionbar_one_title.setText("这个是actionBar的demo");

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_actionbar_one_back:
                onBack();
                break;
            case R.id.tv_actionbar_one_share:
                onShare();
                break;
        }
    }

    private void onBack(){
        this.finish();
    }

    private void onShare(){
        Toast.makeText(ActionbarOneActivity.this,"分享了",Toast.LENGTH_SHORT).show();
    }


}
