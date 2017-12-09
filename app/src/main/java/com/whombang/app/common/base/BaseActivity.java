package com.whombang.app.common.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.githang.statusbar.StatusBarCompat;
import com.whombang.app.R;
import com.whombang.app.common.view.TitleBar;
import com.whombang.app.mvp.component.ApplicationComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Description:Activity的基类 注意：除非特殊，要不必须继承
 * Company:
 * Created by 蒋建伟 on 2017/11/10.
 */

public abstract class BaseActivity<T extends IBasePresenter> extends AppCompatActivity implements IBaseView {
    /**
     * 当前Activity渲染的视图View
     */
    public View rootView;
    protected Activity mActivity;
    protected Context mContext;
    @BindView(R.id.common_titleBar)
   public TitleBar titleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        StatusBarCompat.setStatusBarColor(this, Color.WHITE);
        mActivity = this;
        mContext = getApplicationContext();
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
        ButterKnife.bind(this);
        initInjector();
        initView(savedInstanceState, rootView);
        doBusiness();
        initCommonTitiebar();
    }

    /**
     * 初始化通用的titlebar
     */
    protected  void initCommonTitiebar(){
        titleBar.setImmersive(false);
        titleBar.setBackgroundColor(Color.parseColor("#ffffff"));
        titleBar.setLeftImageResource(R.mipmap.back_icon);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        titleBar.setTitleColor(Color.BLACK);
        titleBar.setDividerColor(Color.WHITE);
        titleBar.setActionTextColor(Color.WHITE);
    }

    /**
     * 绑定布局
     */
    @LayoutRes
    protected abstract int bindLayout();
    /**
     * Dagger 注入
     */
    protected abstract void initInjector();


    /**
     * 设置视图
     *
     * @param layoutId
     */
    protected void setBaseView(int layoutId) {
        rootView = LayoutInflater.from(this).inflate(layoutId, null);
        setContentView(rootView);
    }

    /**
     * 设置屏幕属性
     */
    protected void setScreenArrts() {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                getWindow().getDecorView().setSystemUiVisibility(5895);
                getWindow().getDecorView().requestFocus();
            }
        });
    }
}
