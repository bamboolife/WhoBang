package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.view.View;

import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

/**
 * 新增地址
 */
public class NewlyAddressActivity extends BaseActivity {

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_newly_address_layout;
    }

    @Override
    protected void initInjector() {
       titleBar.setTitle("新增地址");
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {

    }

    @Override
    public void doBusiness() {

    }
}
