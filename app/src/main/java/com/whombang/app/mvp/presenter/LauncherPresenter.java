package com.whombang.app.mvp.presenter;

import com.whombang.app.LauncherActivity;

import javax.inject.Inject;

/**
 * Created by sundy.jiang on 2017/12/5.
 */

public class LauncherPresenter {
    private LauncherActivity mActivity;
    @Inject
    public LauncherPresenter(LauncherActivity mActivity){
        this.mActivity=mActivity;
    }
}
