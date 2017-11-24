package com.whombang.app.common.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created by sundy.jiang on 2017/11/21.
 */

public interface IBaseView {
    /**
     * 初始化数据
     *
     * @param bundle 传递过来的bundle
     */
    void initData(Bundle bundle);

    /**
     * 绑定布局
     */
    int bindLayout();

    /**
     * 初始化view
     */
    void initView(Bundle savedInstanceState, View view);

    /**
     * 业务操作
     */
    void doBusiness();

//    /**
//     * 视图点击事件
//     *
//     * @param view 设置监听的view
//     */
//    void onWidgetClick(View view);
}
