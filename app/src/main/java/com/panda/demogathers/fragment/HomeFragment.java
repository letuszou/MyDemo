package com.panda.demogathers.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.panda.demogathers.R;
import com.panda.demogathers.activity.AboutActivity;
import com.panda.demogathers.activity.AudioPlayActivity;
import com.panda.demogathers.activity.DataActivity;
import com.panda.demogathers.activity.ExpandableListviewActivity;
import com.panda.demogathers.activity.PdfviewActivity;
import com.panda.demogathers.activity.RecyclerActivity;
import com.panda.demogathers.activity.VideoPlayActivity;

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private TextView tv_expand;
    private TextView tv_pdf_read;
    private TextView tv_about;
    private TextView tv_video_play;
    private TextView tv_audio_play;
    private TextView tv_recycler;
    private TextView tv_data;

    public HomeFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        initListener();
        return view;
    }


    private void initView(View view){
        tv_about = (TextView)view.findViewById(R.id.tv_about);
        tv_expand = (TextView)view.findViewById(R.id.tv_expand);
        tv_pdf_read = (TextView)view.findViewById(R.id.tv_pdf_read);
        tv_video_play = (TextView)view.findViewById(R.id.tv_video_play);
        tv_audio_play = (TextView)view.findViewById(R.id.tv_audio_play);
        tv_recycler = (TextView)view.findViewById(R.id.tv_recycler);
        tv_data = (TextView)view.findViewById(R.id.tv_data);

    }


    private void initListener(){
        tv_about.setOnClickListener(this);
        tv_expand.setOnClickListener(this);
        tv_pdf_read.setOnClickListener(this);
        tv_video_play.setOnClickListener(this);
        tv_audio_play.setOnClickListener(this);
        tv_recycler.setOnClickListener(this);
        tv_data.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_about:
                startActivity(new Intent(getActivity(),AboutActivity.class));
                break;
            case R.id.tv_expand:
                startActivity(new Intent(getActivity(),ExpandableListviewActivity.class));
                break;
            case R.id.tv_pdf_read:
                startActivity(new Intent(getActivity(),PdfviewActivity.class));
                break;
            case R.id.tv_video_play:
                startActivity(new Intent(getActivity(),VideoPlayActivity.class));
                break;
            case R.id.tv_audio_play:
                startActivity(new Intent(getActivity(),AudioPlayActivity.class));
                break;
            case R.id.tv_recycler:
                startActivity(new Intent(getActivity(),RecyclerActivity.class));
                break;
            case R.id.tv_data:
                startActivity(new Intent(getActivity(), DataActivity.class));

        }

    }
}
