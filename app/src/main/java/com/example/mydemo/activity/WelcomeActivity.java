package com.example.mydemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mydemo.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        init();
    }



    private void init(){
        startActivity(new Intent(WelcomeActivity.this,IndexActivity.class));
        finish();

    }


}
