package com.panda.demogathers.activity.liebiao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.panda.demogathers.R;
import com.panda.demogathers.activity.BaseActivity;

public class RecyclerActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_recycler_listview_s;
    private TextView tv_recycler_listview_h;
    private TextView tv_recycler_gridview;
    private TextView tv_recycler_strag;
    private TextView tv_recycler_strager;

    @Override
    protected void initLayoutView() {
        setContentView(R.layout.activity_recycler);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_recycler_listview_s:
                Intent intentS = new Intent(RecyclerActivity.this,RecyclerListViewActivity.class);
                intentS.putExtra("isHor",false);
                startActivity(intentS);
                break;
            case R.id.tv_recycler_listview_h:
                Intent intentH = new Intent(RecyclerActivity.this,RecyclerListViewActivity.class);
                intentH.putExtra("isHor",true);
                startActivity(intentH);
                break;
            case R.id.tv_recycler_gridview:
                startActivity(new Intent(RecyclerActivity.this,RecyclerGridviewActivity.class));
                break;
            case R.id.tv_recycler_strag:
                startActivity(new Intent(RecyclerActivity.this,RecyclerStagActivity.class));
                break;
            case R.id.tv_recycler_strager:
                startActivity(new Intent(RecyclerActivity.this,RecyclerStagverActivity.class));
                break;


        }


    }


    @Override
    public void initView(){
        tv_recycler_listview_s = (TextView)findViewById(R.id.tv_recycler_listview_s);
        tv_recycler_gridview = (TextView)findViewById(R.id.tv_recycler_gridview);
        tv_recycler_listview_h=(TextView)findViewById(R.id.tv_recycler_listview_h);
        tv_recycler_strag = (TextView)findViewById(R.id.tv_recycler_strag);
        tv_recycler_strager = (TextView)findViewById(R.id.tv_recycler_strager);

        setListener();
    }

    private void setListener(){
        tv_recycler_listview_s.setOnClickListener(this);
        tv_recycler_listview_h.setOnClickListener(this);
        tv_recycler_gridview.setOnClickListener(this);
        tv_recycler_strag.setOnClickListener(this);
        tv_recycler_strager.setOnClickListener(this);

    }


}
