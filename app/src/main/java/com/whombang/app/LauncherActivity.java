package com.whombang.app;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.whombang.app.common.base.BaseActivity;
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
        return R.layout.wb_lanucher_layout;
    }

    @Override
    protected void initInjector() {
        DaggerLauncherActivityComponent.builder().launcherActivityModule(new LauncherActivityModule(this)).build().inject(this);

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {


    }

    @Override
    public void doBusiness() {
        titleBar.setVisibility(View.GONE);
        presenter.onStartAnimAndJump(imgLogo);
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
