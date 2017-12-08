package com.whombang.app;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.systembar.SystemBarManager;
import com.whombang.app.mvp.component.DaggerLauncherActivityComponent;
import com.whombang.app.mvp.module.LauncherActivityModule;
import com.whombang.app.mvp.presenter.LauncherPresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * 启动页
 */
public class LauncherActivity extends BaseActivity {
    @BindView(R.id.img_logo)
    ImageView imgLogo;

    @Inject
    LauncherPresenter presenter;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_lanucher;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        SystemBarManager.setStatusBarLightMode(this,android.R.color.transparent);
        DaggerLauncherActivityComponent.builder().launcherActivityModule(new LauncherActivityModule(this)).build().inject(this);

    }

    @Override
    public void doBusiness() {
        arouterJump();
        countdown(4).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Log.i("www", "accept: 倒计时： " + aLong);
            }
        });
    }
    /**
     * 路由延迟跳转
     */
    private void arouterJump() {
        Flowable.interval(3, TimeUnit.SECONDS)
                .take(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.i("www","long="+aLong);
                        //ARouter.getInstance().build("/main/tab").navigation();
                    }
                });
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(imgLogo, "scaleX", 0f,1f);
        animatorX.setDuration(3000);
        animatorX.start();
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(imgLogo, "scaleY", 0f,1f);
        animatorY.setDuration(3000);
        animatorY.start();
        ObjectAnimator alpha = ObjectAnimator.ofFloat(imgLogo, "alpha", 0f,1f);
        alpha.setDuration(3000);
        alpha.start();
        AnimatorSet set=new AnimatorSet();
        set.playTogether(animatorX,animatorY,alpha);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ARouter.getInstance().build("/main/tab").navigation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
    /**
     * 倒计时
     * @param time
     * @return
     */
    public Observable<Long> countdown(final long time){
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return time-aLong;
                    }
                }).take(time+1);
    }

}
