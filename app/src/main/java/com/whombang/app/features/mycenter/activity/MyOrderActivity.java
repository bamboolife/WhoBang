package com.whombang.app.features.mycenter.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.TitleBar;

import butterknife.BindView;

/**
 * 服务订单
 */
@Route(path = "/order/service")
public class MyOrderActivity extends BaseActivity {
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_my_order_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("服务订单");
    }

    @Override
    public void doBusiness() {

    }
}
