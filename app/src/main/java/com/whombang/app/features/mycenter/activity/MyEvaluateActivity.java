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
 * 我的评价
 */
@Route(path = "/my/evaluate")
public class MyEvaluateActivity extends BaseActivity {
    @BindView(R.id.evaluate_titlebar)
    TitleBar titleBar;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_my_evaluate;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        initTitleBar();
    }

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
        titleBar.setTitle("我的评价");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

        titleBar.setActionTextColor(Color.WHITE);
    }

    @Override
    public void doBusiness() {

    }
}
