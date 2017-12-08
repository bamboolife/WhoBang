package com.whombang.app.mvp.module;

import android.content.Context;

import com.whombang.app.common.base.BaseApplication;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sundy.jiang on 2017/12/5.
 */
@Module
public class ApplicationModule {
    private final BaseApplication mApplocation;

    public ApplicationModule(BaseApplication applocation){
        this.mApplocation=applocation;
    }

    @Provides
    @Singleton
    BaseApplication provideApplication(){
        return mApplocation;
    }
}
