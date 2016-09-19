package com.panda.demogathers.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.panda.demogathers.R;
import com.panda.demogathers.fragment.HomeFragment;
import com.panda.demogathers.fragment.MeFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private ImageView iv_activity_home;
    private ImageView iv_activity_me;
    private RelativeLayout rl_fragment_left;
    private RelativeLayout rl_fragment_right;
    private HomeFragment homeFragment;
    private MeFragment meFragment;
    private TextView tv_activity_me;
    private TextView tv_activity_home;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//隐藏掉整个ActionBar，包括下面的Tabs
        setContentView(R.layout.activity_home);
        initView();

    }

    private void initView() {
        iv_activity_home = (ImageView) findViewById(R.id.iv_activity_home);
        iv_activity_me = (ImageView) findViewById(R.id.iv_activity_me);
        tv_activity_me = (TextView)findViewById(R.id.tv_activity_me);
        tv_activity_home = (TextView)findViewById(R.id.tv_activity_home);
        rl_fragment_left = (RelativeLayout) findViewById(R.id.rl_fragment_left);
        rl_fragment_right = (RelativeLayout) findViewById(R.id.rl_fragment_right);
        rl_fragment_left.setOnClickListener(this);
        rl_fragment_right.setOnClickListener(this);

        setLeftFragment();

    }


    private void setLeftFragment() {
        iv_activity_home.setImageResource(R.drawable.selected_home);
        iv_activity_me.setImageResource(R.drawable.select_me);
        tv_activity_me.setTextColor(getResources().getColor(R.color.white));
        tv_activity_home.setTextColor(getResources().getColor(R.color.blue));
        homeFragment = new HomeFragment();
        meFragment = new MeFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, homeFragment);
        fragmentTransaction.commit();
    }
    private void setRightFragment(){
        iv_activity_home.setImageResource(R.drawable.select_home);
        iv_activity_me.setImageResource(R.drawable.selected_me);
        tv_activity_me.setTextColor(getResources().getColor(R.color.blue));
        tv_activity_home.setTextColor(getResources().getColor(R.color.white));
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, meFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_fragment_left:
                setLeftFragment();
                break;
            case R.id.rl_fragment_right:
                setRightFragment();
                break;

        }

    }
}
