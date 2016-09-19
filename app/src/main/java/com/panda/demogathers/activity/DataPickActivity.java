package com.panda.demogathers.activity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.panda.demogathers.R;

import java.util.Calendar;

public class DataPickActivity extends BaseActivity {

    private EditText dateEt=null;
    private EditText timeEt=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_pick);
        dateEt=(EditText)findViewById(R.id.et_data_pick_data);
        timeEt=(EditText)findViewById(R.id.et_data_pick_time);
        DatePicker datePicker=(DatePicker)findViewById(R.id.pick_data);
        TimePicker timePicker=(TimePicker)findViewById(R.id.pick_time);

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener(){

            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                dateEt.setText("您选择的日期是："+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日。");
            }

        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeEt.setText("您选择的时间是："+hourOfDay+"时"+minute+"分。");
            }

        });
    }
}