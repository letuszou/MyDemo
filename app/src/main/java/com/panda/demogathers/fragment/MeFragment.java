package com.panda.demogathers.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.panda.demogathers.R;
import com.panda.demogathers.domain.MyUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;
import cn.com.videopls.venvy.f.V;

public class MeFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout rl_fragment_login;
    private RelativeLayout rl_fragment_register;
    private Button btn_login;
    private Button btn_register;
    private Button btn_register_register;
    private RelativeLayout rl_fragment_logined;
    private EditText et_password_login;
    private EditText et_username_login;
    private EditText et_username_register;
    private EditText et_password_register;
    private EditText et_email_register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);
        initListener();
        isLogined();
        return view;
    }
    private void isLogined(){
        BmobUser bmobUser = BmobUser.getCurrentUser(getActivity());
        if(bmobUser != null){
            // 允许用户使用应用
            rl_fragment_login.setVisibility(View.GONE);
            rl_fragment_register.setVisibility(View.GONE);
            rl_fragment_logined.setVisibility(View.VISIBLE);
        }else{
            //缓存用户对象为空时， 可打开用户注册界面…

        }
    }

    private void initView(View view){
        rl_fragment_login = (RelativeLayout) view.findViewById(R.id.rl_fragment_login);
        rl_fragment_register = (RelativeLayout)view.findViewById(R.id.rl_fragment_register);
        rl_fragment_logined = (RelativeLayout)view.findViewById(R.id.rl_fragment_logined);
        btn_login = (Button)view.findViewById(R.id.btn_login);
        btn_register = (Button)view.findViewById(R.id.btn_register);
        btn_register_register = (Button)view.findViewById(R.id.btn_register_register);
        et_password_login = (EditText)view.findViewById(R.id.et_password_login);
        et_username_login = (EditText)view.findViewById(R.id.et_username_login);
        et_username_register = (EditText) view.findViewById(R.id.et_username_register);
        et_password_register = (EditText) view.findViewById(R.id.et_password_register);
        et_email_register = (EditText) view.findViewById(R.id.et_email_register);


    }

    private void initListener(){
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_register_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                loginPrepare();
                break;
            case R.id.btn_register:
                registerPrepare();
                break;
            case R.id.btn_register_register:
                register();
                break;

        }

    }


    private void loginPrepare(){

        String password =et_password_login.getText().toString().trim();
        String username=et_username_login.getText().toString().trim();


        if(TextUtils.isEmpty(password)||TextUtils.isEmpty(username)){
            Toast.makeText(getActivity(),"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length()<6||et_username_login.length()<6){
            Toast.makeText(getActivity(),"用户名或密码别太短小了!",Toast.LENGTH_SHORT).show();
            return;
        }

        MyUser myUser = new MyUser();
        myUser.setUsername(username);
        myUser.setPassword(password);
        myUser.login(getActivity(), new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(getActivity(),"登录成功",Toast.LENGTH_SHORT).show();
                loginSuccess();
            }


            @Override
            public void onFailure(int i, String s) {
            Toast.makeText(getActivity(),"登录出现错:"+s+",错误代码:"+i,Toast.LENGTH_SHORT).show();
            }
        });





    }



    private void registerPrepare(){
        rl_fragment_login.setVisibility(View.GONE);
        rl_fragment_register.setVisibility(View.VISIBLE);

    }

    private void register(){

        String username=et_username_register.getText().toString().trim();
        String password=et_password_register.getText().toString().trim();
        String email=et_email_register.getText().toString().trim();

        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)||TextUtils.isEmpty(email)){
            Toast.makeText(getActivity(),"用户名或密码或电子邮箱不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length()<6||username.length()<6||et_email_register.length()<0){
            Toast.makeText(getActivity(),"用户名或密码别太短小了!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!isEmail(email)){
            Toast.makeText(getActivity(),"哥哥,还是输入电子邮箱吧!!!",Toast.LENGTH_SHORT).show();
            return;
        }
        MyUser myUser = new MyUser();
        myUser.setUsername(username);
        myUser.setPassword(password);
        myUser.setEmail(email);
        myUser.signUp(getActivity(), new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(getActivity(),"注册成功!",Toast.LENGTH_SHORT).show();
                registerSuccess();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(getActivity(),"登录出现错:"+s+",错误代码:"+i,Toast.LENGTH_SHORT).show();
            }
        });

    }


    public static boolean isEmail(String strEmail) {
        String strPattern = "^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(strEmail);
        return m.matches();
    }

    private void registerSuccess(){
        rl_fragment_login.setVisibility(View.VISIBLE);
        rl_fragment_register.setVisibility(View.GONE);
        rl_fragment_logined.setVisibility(View.GONE);
    }

    private void loginSuccess(){
        rl_fragment_login.setVisibility(View.GONE);
        rl_fragment_register.setVisibility(View.GONE);
        rl_fragment_logined.setVisibility(View.VISIBLE);
    }


}
