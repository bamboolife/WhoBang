package com.whombang.app.features.sendtask;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.githang.statusbar.StatusBarCompat;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.systembar.SystemBarManager;
import com.whombang.app.common.view.TitleBar;

import butterknife.BindView;

/**
 * 电话服务列表
 */
@Route(path = "/task/phone")
public class ServicePhoneActivity extends BaseActivity {
    @BindView(R.id.phone_titlebar)
    TitleBar titleBar;

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
        StatusBarCompat.setStatusBarColor(this, Color.WHITE);
        initTitleBar();
    }

    private void initTitleBar() {
        titleBar.setImmersive(false);
        titleBar.setBackgroundColor(Color.parseColor("#ffffff"));
        titleBar.setLeftImageResource(R.mipmap.back_green);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitle("电话列表");
        titleBar.setTitleColor(Color.BLACK);
        titleBar.setDividerColor(Color.WHITE);

        titleBar.setActionTextColor(Color.WHITE);
    }

    @Override
    public void doBusiness() {

    }
}
