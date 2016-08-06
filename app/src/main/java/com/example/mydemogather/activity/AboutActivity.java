package com.example.mydemogather.activity;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mydemogather.R;

import cn.bmob.v3.listener.BmobUpdateListener;
import cn.bmob.v3.update.BmobUpdateAgent;
import cn.bmob.v3.update.UpdateResponse;
import cn.bmob.v3.update.UpdateStatus;

public class AboutActivity extends BaseActivity {

    private TextView about_tv_send;
    private TextView about_tv_update_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        initView();


    }


    private void initView() {

        //


        about_tv_send = (TextView) findViewById(R.id.about_tv_send);
        about_tv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this, "发送邮件", Toast.LENGTH_SHORT).show();
                sendEmail();
            }
        });

        about_tv_update_update = (TextView) findViewById(R.id.about_tv_update_update);
        about_tv_update_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

    }

    private void update() {
        BmobUpdateAgent.setUpdateListener(new BmobUpdateListener() {

            @Override
            public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
                // TODO Auto-generated method stub
                if (updateStatus == UpdateStatus.Yes) {//版本有更新

                }else if(updateStatus == UpdateStatus.No){
                    Toast.makeText(AboutActivity.this, "版本无更新", Toast.LENGTH_SHORT).show();
                }else if(updateStatus==UpdateStatus.EmptyField){//此提示只是提醒开发者关注那些必填项，测试成功后，无需对用户提示
                    Toast.makeText(AboutActivity.this, "请检查你AppVersion表的必填项，1、target_size（文件大小）是否填写；2、path或者android_url两者必填其中一项。", Toast.LENGTH_SHORT).show();
                }else if(updateStatus==UpdateStatus.IGNORED){
                    Toast.makeText(AboutActivity.this, "该版本已被忽略更新", Toast.LENGTH_SHORT).show();
                }else if(updateStatus==UpdateStatus.ErrorSizeFormat){
                    Toast.makeText(AboutActivity.this, "请检查target_size填写的格式，请使用file.length()方法获取apk大小。", Toast.LENGTH_SHORT).show();
                }else if(updateStatus==UpdateStatus.TimeOut){
                    Toast.makeText(AboutActivity.this, "查询出错或查询超时", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //发起自动更新
        BmobUpdateAgent.update(this);
    }


    private void inputEmail() {

        // 1.创建弹出式对话框
        final AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(AboutActivity.this);    // 系统默认Dialog没有输入框
        // 获取自定义的布局
        View alertDialogView = View.inflate(AboutActivity.this, R.layout.dialog_input, null);
        // 2.密码框-EditText。alertDialogView.findViewById(R.id.自定义布局中的文本框)
        final EditText et_dialog_email_input = (EditText) alertDialogView.findViewById(R.id.et_dialog_email_input);
        // 确认按钮，确认验证密码
        Button btn_dialog_email_confirm = (Button) alertDialogView.findViewById(R.id.btn_dialog_email_confirm);
        btn_dialog_email_confirm.setOnClickListener(new View.OnClickListener() {
            // 点击按钮处理
            public void onClick(View v) {
                // 提取文本框中输入的文本密码
                String emailAddress = et_dialog_email_input.toString().trim();
                if (TextUtils.isEmpty(emailAddress)) {
                    Toast.makeText(AboutActivity.this, "电子邮件不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    sendEmail( );
                }

            }
        });
        // 取消按钮
        Button btn_dialog_email_cancle = (Button) alertDialogView.findViewById(R.id.btn_dialog_email_cancle);
        btn_dialog_email_cancle.setOnClickListener(new View.OnClickListener() {
            // 点击按钮处理
            public void onClick(View v) {
                //
            }
        });

        AlertDialog tempDialog = alertDialog.create();
        tempDialog.setView(alertDialogView, 0, 0, 0, 0);

        /** 3.自动弹出软键盘 **/
        tempDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialog) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(et_dialog_email_input, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        tempDialog.show();
    }


    private void sendEmail() {
        String[] email = {"letuszou@126.com"}; // 需要注意，email必须以数组形式传入
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822"); // 设置邮件格式
        intent.putExtra(Intent.EXTRA_EMAIL, email); // 接收人
        intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
        intent.putExtra(Intent.EXTRA_SUBJECT, "索取安卓Demo源码"); // 主题
        intent.putExtra(Intent.EXTRA_TEXT, "请输入你的有效的电子邮箱地址或者其他内容："); // 正文
        startActivity(Intent.createChooser(intent, "请选择邮件类应用"));
    }


}
