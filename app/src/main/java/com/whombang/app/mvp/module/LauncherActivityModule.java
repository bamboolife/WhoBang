package com.whombang.app.mvp.module;


import com.whombang.app.LauncherActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2017/12/5.
 */
@Module
public class LauncherActivityModule {
    private LauncherActivity launchActivity;

    public LauncherActivityModule(LauncherActivity launchActivity) {
        this.launchActivity = launchActivity;
    }

    @Provides
    LauncherActivity provideTrailActivity() {
        return launchActivity;
    }
}
