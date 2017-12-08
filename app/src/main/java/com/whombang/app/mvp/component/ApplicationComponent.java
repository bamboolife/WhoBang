package com.whombang.app.mvp.component;

import android.app.Application;
import android.content.Context;

import com.whombang.app.common.base.BaseApplication;
import com.whombang.app.mvp.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sundy.jiang on 2017/12/5.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    BaseApplication getApplication();
}
