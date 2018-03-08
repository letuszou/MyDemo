package com.panda.demogathers.activity.liebiao;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;
import com.panda.demogathers.R;
import com.panda.demogathers.activity.BaseActivity;
import com.panda.demogathers.adapter.RecyclerListviewAdapter;
import com.panda.demogathers.view.DividerGridItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class RecyclerGridviewActivity extends BaseActivity {


    private RecyclerView mRecyclerView;
    private GridLayoutManager  mLayoutManager;
    private RecyclerListviewAdapter recyclerAdapter;
    private List myData;
    private StaggeredGridLayoutManager mLayoutManager1;

    @Override
    protected void initLayoutView() {
        setContentView(R.layout.activity_recycle_gridview);
    }


    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_view_gridview);

    }

    @Override
    protected void init() {

        //创建默认的线性LayoutManager
        mLayoutManager = new GridLayoutManager(this,4);

        mRecyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //创建并设置Adapter
        recyclerAdapter = new RecyclerListviewAdapter(this, myData);
//        LinearLayoutManager 现行管理器，支持横向、纵向。
        mRecyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickLitener(new RecyclerListviewAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerGridviewActivity.this,"短点击了"+position+"是"+myData.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerGridviewActivity.this,"长点击了"+"是"+myData.get(position)+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void initData() {
        myData = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            myData.add("" + (char) i);
        }
    }

    //这个是listview 形式的展示 修改了系统自定义的线  当然 你可一改回来

}
