package com.whombang.app.common.base;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.whombang.app.mvp.component.ApplicationComponent;
import com.whombang.app.mvp.component.DaggerApplicationComponent;
import com.whombang.app.mvp.module.ApplicationModule;

/**
 * Description:全局初始化和属性在此定义
 * Company:
 * Created by 蒋建伟 on 2017/11/10.
 */

public class BaseApplication extends MultiDexApplication {
    private boolean isDebug=true;
    private BaseApplication baseApplication;
    private  ApplicationComponent appComponent;

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication=this;
        Fresco.initialize(this);
        initArouter();
        initInjector();
    }

    /**
     * 初始化注射器
     */
    private void initInjector() {
        appComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    /**
     * 初始化路由管理
     */
    private void initArouter() {
        if (isDebug) {                  // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();          // 打印日志
            ARouter.openDebug();        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

    public BaseApplication getBaseApplication() {
        return baseApplication;
    }
}
