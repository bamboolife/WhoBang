package com.whombang.app.features;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;

import com.whombang.app.common.systembar.SystemBarManager;



import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;


/**
 * 向导页
 */
@Route(path = "/main/guide")
public class GuideActivity extends BaseActivity {
    @BindView(R.id.banner_guide_background)
    BGABanner mBackgroundBanner;
//    @BindView(R.id.banner_guide_foreground)
//    BGABanner mForegroundBanner;

    @Override
    protected int bindLayout() {
        return R.layout.wb_guide_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setVisibility(View.GONE);
        SystemBarManager.translucentStatusBar(this, false);
    }

    @Override
    public void doBusiness() {

        mBackgroundBanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                ARouter.getInstance().build("/user/login").navigation();
                finish();
            }
        });
        // 设置数据源
        mBackgroundBanner.setData(R.mipmap.uoko_guide_background_1, R.mipmap.uoko_guide_background_2, R.mipmap.uoko_guide_background_3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 如果开发者的引导页主题是透明的，需要在界面可见时给背景 Banner 设置一个白色背景，避免滑动过程中两个 Banner 都设置透明度后能看到 Launcher
        mBackgroundBanner.setBackgroundResource(android.R.color.white);
    }
}
