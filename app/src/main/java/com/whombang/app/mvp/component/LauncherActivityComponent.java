package com.whombang.app.mvp.component;

import com.whombang.app.LauncherActivity;
import com.whombang.app.mvp.module.LauncherActivityModule;

import dagger.Component;

/**
 * Created by sundy.jiang on 2017/12/5.
 */
@Component(modules = LauncherActivityModule.class)
public interface LauncherActivityComponent {
    void inject(LauncherActivity launchActivity);
}
