package com.whombang.app.features.login;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.TitleBar;

import butterknife.BindView;

/**
 * 用户注册
 */
@Route(path = "/user/register")
public class RegisterActivity extends BaseActivity {
    @BindView(R.id.register_titlebar)
    TitleBar titleBar;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_register_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initTitleBar();
    }

    /**
     * 初始化title
     */
    private void initTitleBar() {
        titleBar.setImmersive(false);
        titleBar.setBackgroundColor(Color.parseColor("#ec0f38"));
        titleBar.setLeftImageResource(R.mipmap.back_green);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitle("登陆");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);
        titleBar.setActionTextColor(Color.WHITE);
    }

    @Override
    public void doBusiness() {

    }
}
