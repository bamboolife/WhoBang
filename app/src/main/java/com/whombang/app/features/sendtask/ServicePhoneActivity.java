package com.whombang.app.features.sendtask;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

/**
 * 电话服务列表
 */
@Route(path = "/task/phone")
public class ServicePhoneActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.wb_service_phone_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("电话列表");
    }



    @Override
    public void doBusiness() {

    }
}
