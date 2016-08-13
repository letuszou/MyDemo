package com.panda.demogathers.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.panda.demogathers.R;
import com.panda.demogathers.adapter.RecyclerListviewAdapter;
import com.panda.demogathers.view.DividerListItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class RecyclerListViewActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager  mLayoutManager;
    private RecyclerListviewAdapter recyclerAdapter;
    private List myData;
    private Boolean isHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_listview);

        isHor = getIntent().getBooleanExtra("isHor",false);

        initData();

        initView();

        init();

    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_view_listview);

    }

    private void init() {

        //创建默认的线性LayoutManager
        mLayoutManager = new LinearLayoutManager (this);

        if(isHor){
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            //添加分割线
            mRecyclerView.addItemDecoration(new DividerListItemDecoration(this,LinearLayoutManager.HORIZONTAL));
        }else {
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.addItemDecoration(new DividerListItemDecoration(this,LinearLayoutManager.VERTICAL));
        }


        mRecyclerView.setLayoutManager(mLayoutManager);
//        如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
//        mRecyclerView.setHasFixedSize(true);


        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //创建并设置Adapter
        recyclerAdapter = new RecyclerListviewAdapter(this, myData);
//        LinearLayoutManager 现行管理器，支持横向、纵向。
//        GridLayoutManager 网格布局管理器
//        StaggeredGridLayoutManager 瀑布就式布局管理器
        mRecyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickLitener(new RecyclerListviewAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerListViewActivity.this,"短点击了"+position+"是"+myData.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerListViewActivity.this,"长点击了"+"是"+myData.get(position)+position,Toast.LENGTH_SHORT).show();
            }
        });

    }


    protected void initData() {
        myData = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            myData.add("" + (char) i);
        }
    }

    //这个是listview 形式的展示 修改了系统自定义的线  当然 你可一改回来

}
