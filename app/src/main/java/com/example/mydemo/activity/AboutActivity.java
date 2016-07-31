package com.example.mydemo.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemo.R;

public class AboutActivity extends AppCompatActivity {

    private TextView about_tv_send;
    private TextView about_tv_update_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initView();


    }




    private void initView(){

        //



        about_tv_send = (TextView)findViewById(R.id.about_tv_send);
        about_tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this,"发送邮件",Toast.LENGTH_SHORT).show();
                String[] email = {"letuszou@126.com"}; // 需要注意，email必须以数组形式传入
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822"); // 设置邮件格式
                intent.putExtra(Intent.EXTRA_EMAIL, email); // 接收人
                intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
                intent.putExtra(Intent.EXTRA_SUBJECT, "索取安卓Demo源码"); // 主题
                intent.putExtra(Intent.EXTRA_TEXT, "请填写你的有效的电子邮箱地址："); // 正文
                startActivity(Intent.createChooser(intent, "请选择邮件类应用"));
            }
        });

        about_tv_update_update = (TextView)findViewById(R.id.about_tv_update_update);
        about_tv_update_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              update();
            }
        });

    }

    private void update(){
        Toast.makeText(AboutActivity.this,"点击了升级",Toast.LENGTH_SHORT).show();
    }


}
