package com.whombang.app.features.login;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

import butterknife.OnClick;

/**
 * 登陆页面
 */
@Route(path = "/user/login")
public class LoginActivity extends BaseActivity {

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_login_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("登陆");
    }


    @Override
    public void doBusiness() {

    }

    @OnClick(R.id.btn_login)
    public void onStartLogin(View v){

    }

    @OnClick(R.id.tv_register)
    public void registerUser(){
        ARouter.getInstance().build("/user/register").navigation();
    }

    @OnClick(R.id.tv_forget)
    public void forgetPassWord(){
        ARouter.getInstance().build("/user/forget").navigation();
    }
}
