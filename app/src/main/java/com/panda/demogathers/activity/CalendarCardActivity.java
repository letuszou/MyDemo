package com.panda.demogathers.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.panda.demogathers.R;
import com.wt.calendarcard.CalendarCard;
import com.wt.calendarcard.CardGridItem;
import com.wt.calendarcard.OnCellItemClick;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class CalendarCardActivity extends AppCompatActivity {

    private TextView tv_data_calendarCard;
    private CalendarCard data_calendarCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_card);

        initView();

        init();

    }


    private void initView(){
         tv_data_calendarCard= (TextView)findViewById(R.id.tv_data_calendarCard);
        data_calendarCard = (CalendarCard)findViewById(R.id.data_calendarCard);

    }
    private void init(){
        data_calendarCard.setOnCellItemClick(new OnCellItemClick() {
            @Override
            public void onCellClick(View v, CardGridItem item) {
                tv_data_calendarCard.setText(getResources().getString(R.string.select_calendar_card, new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(item.getDate().getTime())));
            }
        });
    }


}
