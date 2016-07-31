package com.example.mydemo.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.mydemo.R;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_expand;
    private TextView tv_button_switch;
    private TextView tv_pdf_read;
    private TextView tv_about;

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
        tv_button_switch = (TextView)findViewById(R.id.tv_button_switch);
        tv_pdf_read = (TextView)findViewById(R.id.tv_pdf_read);

    }


    private void initListener(){
        tv_about.setOnClickListener(this);
        tv_expand.setOnClickListener(this);
        tv_button_switch.setOnClickListener(this);
        tv_pdf_read.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_about:
                startActivity(new Intent(IndexActivity.this,AboutActivity.class));
                break;
//            case R.id.tv_expand:
//                startActivity(new Intent(IndexActivity.this,ExpandListViewActivity.class));
//                break;
//            case R.id.tv_button_switch:
//                startActivity(new Intent(IndexActivity.this,ButtonSwitchActivity.class));
//                break;
//            case R.id.tv_pdf_read:
//                startActivity(new Intent(IndexActivity.this,PdfActivity.class));
//                break;

        }

    }
}
