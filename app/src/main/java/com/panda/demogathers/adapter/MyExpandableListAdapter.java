package com.panda.demogathers.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.panda.demogathers.R;

/**
 * Created by admin on 2016/7/31.
 */
public class MyExpandableListAdapter implements ExpandableListAdapter {

    private Context myContext;
    public MyExpandableListAdapter(Context context){
        this.myContext =context;
    }


    int[] logos = new int[]{
            R.drawable.word,
            R.drawable.excel,
            R.drawable.email,
            R.drawable.ppt
    };
    private String[] armTypes = new String[]{
            "WORD", "EXCEL", "EMAIL", "PPT"
    };
    private String[][] arms = new String[][]{
            {"文档编辑", "文档排版", "文档处理", "文档打印"},
            {"表格编辑", "表格排版", "表格处理", "表格打印"},
            {"收发邮件", "管理邮箱", "登录登出", "注册绑定"},
            {"演示编辑", "演示排版", "演示处理", "演示打印"},
    };

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return armTypes.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arms[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return armTypes[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arms[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(myContext).inflate(R.layout.adapter_expandable_one, null);
        TextView tv_adapter_expand=(TextView) convertView.findViewById(R.id.tv_adapter_expand);
        tv_adapter_expand.setText(getGroup(groupPosition).toString());

        ImageView iv_adapter_expand=(ImageView) convertView.findViewById(R.id.iv_adapter_expand);
        iv_adapter_expand.setImageResource(logos[groupPosition]);

        return convertView;


    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(myContext).inflate(R.layout.adapter_expandable_two, null);
        TextView tv_adapter_expand_two=(TextView) convertView.findViewById(R.id.tv_adapter_expand_two);
        tv_adapter_expand_two.setText(getChild(groupPosition, childPosition).toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    private TextView getTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
        TextView textView = new TextView(myContext);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(20);
        return textView;
    }
}