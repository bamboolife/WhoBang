package com.whombang.app.features.login;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

@Route(path = "/user/forget")
public class ForgetActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.wb_forget_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("忘记密码");
    }

    @Override
    public void doBusiness() {

    }
}
