package com.panda.demogathers.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.panda.demogathers.R;
import com.panda.demogathers.adapter.RecyclerStagAdapter;
import com.panda.demogathers.view.DividerGridItemDecoration;
import java.util.ArrayList;
import java.util.List;

public class RecyclerStagverActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private RecyclerStagAdapter recyclerAdapter;
    private List myData;
    private StaggeredGridLayoutManager mLayoutManager;
    private List<Integer> mHeights;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_stagver);
        initData();

        initView();

        init();

    }


    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_view_stagver);
    }

    private void init() {

        //创建默认的线性LayoutManager
        mLayoutManager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);


        mRecyclerView.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //创建并设置Adapter
        recyclerAdapter = new RecyclerStagAdapter(this, myData,mHeights);
//        LinearLayoutManager 现行管理器，支持横向、纵向。
        mRecyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnItemClickLitener(new RecyclerStagAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerStagverActivity.this,"短点击了"+position+"是"+myData.get(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RecyclerStagverActivity.this,"长点击了"+"是"+myData.get(position)+position,Toast.LENGTH_SHORT).show();
            }
        });

    }


    protected void initData() {
        myData = new ArrayList<String>();
        mHeights = new ArrayList<Integer>();
        for (int i = 'A'; i < 'z'; i++) {
            myData.add("" + (char) i);
            mHeights.add( (int) (100 + Math.random() * 300));
        }
    }

    //这个是listview 形式的展示 修改了系统自定义的线  当然 你可一改回来

}
