package com.panda.demogathers.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.panda.demogathers.R;

public class DataActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_data_picker;
    private TextView tv_data_calendar_card;
    private TextView tv_data_google_calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        initView();

        setListener();

    }

    private void initView(){
        tv_data_picker = (TextView)findViewById(R.id.tv_data_picker);
        tv_data_calendar_card = (TextView)findViewById(R.id.tv_data_calendar_card);
        tv_data_google_calendar = (TextView)findViewById(R.id.tv_data_google_calendar);

    }

    private void setListener(){
        tv_data_picker.setOnClickListener(this);
        tv_data_calendar_card.setOnClickListener(this);
        tv_data_google_calendar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_data_picker:
                startActivity(new Intent(DataActivity.this,DataPickActivity.class));
                break;
            case R.id.tv_data_calendar_card:
                startActivity(new Intent(DataActivity.this,CalendarCardActivity.class));
                break;
            case R.id.tv_data_google_calendar:
                startActivity(new Intent(DataActivity.this,DataGoogleActivity.class));
                break;


        }

    }
}
