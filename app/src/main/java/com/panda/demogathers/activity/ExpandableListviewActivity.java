package com.panda.demogathers.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import com.panda.demogathers.R;
import com.panda.demogathers.adapter.MyExpandableListAdapter;

public class ExpandableListviewActivity extends BaseActivity {

    private ExpandableListView list_expandable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_listview);

        initView();

        init();

        setClick();


    }




    private void initView(){
        list_expandable = (ExpandableListView) findViewById(R.id.list_expandable);
    }


    private void init(){

        MyExpandableListAdapter myExpandableListAdapter = new MyExpandableListAdapter(this);
        list_expandable.setAdapter(myExpandableListAdapter);


    }


    private void setClick(){

        list_expandable.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(ExpandableListviewActivity.this,"点击了一级目录!",Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        list_expandable.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ExpandableListviewActivity.this,"点击了二级目录!",Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }




}