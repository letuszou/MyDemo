package com.example.mydemogather.activity;

import android.content.Intent;
import android.os.Bundle;
import com.example.mydemogather.util.Config;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.update.BmobUpdateAgent;

public class WelcomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bmobInit();

        init();
    }

    private void bmobInit(){
        //初始化BmobSDK,实例化Bmob后端云
        Bmob.initialize(this, Config.Bmob_Api);
        //SDK创建表(测试是调用一次,之后注掉)
//        BmobUpdateAgent.initAppVersion(this);
        //开启自动更新
        BmobUpdateAgent.update(this);


    }



    private void init(){
        startActivity(new Intent(WelcomeActivity.this,IndexActivity.class));
        finish();

    }


}
