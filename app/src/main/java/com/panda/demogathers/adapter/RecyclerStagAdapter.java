package com.panda.demogathers.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.panda.demogathers.R;

import java.util.List;

public class RecyclerStagAdapter extends RecyclerView.Adapter<RecyclerStagAdapter.MyViewHolder> {


    private Context context;
    private List<String> list;
    private List<Integer> mHeights;

    public RecyclerStagAdapter(Context context, List<String> list, List<Integer> mHeights) {
        this.context = context;
        this.list = list;
        this.mHeights = mHeights;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_stag, viewGroup, false));
        return myViewHolder;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder myViewHolder, int position) {

        ViewGroup.LayoutParams lp = myViewHolder.tv_recycler_adapter.getLayoutParams();
        lp.height = mHeights.get(position);
        myViewHolder.tv_recycler_adapter.setLayoutParams(lp);
        myViewHolder.tv_recycler_adapter.setText(list.get(position));

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = myViewHolder.getPosition();
                    mOnItemClickLitener.onItemClick(myViewHolder.itemView, pos);
                }
            });

            myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = myViewHolder.getPosition();
                    mOnItemClickLitener.onItemLongClick(myViewHolder.itemView, pos);
                    return false;
                }
            });
        }

        myViewHolder.tv_recycler_adapter.setText(list.get(position));

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_recycler_adapter;

        public MyViewHolder(View view) {
            super(view);
            tv_recycler_adapter = (TextView) view.findViewById(R.id.tv_recycler_listview_adapter);
        }
    }


}
