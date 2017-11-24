package com.whombang.app.common.base;

import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Description:
 * Company:
 * Created by sundy.jiang on 2017/11/10.
 */

public class BaseApplocation extends MultiDexApplication {
    private boolean isDebug=true;
    @Override
    public void onCreate() {
        super.onCreate();
        initArouter();
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
}
