package com.whombang.app;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.net.BaseSubscriber;
import com.whombang.app.common.net.ExceptionHandle;
import com.whombang.app.common.net.RetrofitClient;
import com.whombang.app.mvp.component.DaggerLauncherActivityComponent;
import com.whombang.app.mvp.module.LauncherActivityModule;
import com.whombang.app.mvp.presenter.LauncherPresenter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

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
//        arouterJump();
//        countdown(4).subscribe(new Consumer<Long>() {
//            @Override
//            public void accept(Long aLong) throws Exception {
//                Log.i("www", "accept: 倒计时： " + aLong);
//            }
//        });
      //  Log.i("wwww", "sha1: ="+sHA1());
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), "");

        RetrofitClient.getInstance(this)
                .createBaseApi()
                .json("WhomBangServer/getFirstPageParam", body)
                .subscribe(new BaseSubscriber<ResponseBody>(LauncherActivity.this) {


                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {
                        Log.e("Lyk", e.getMessage());
                        Toast.makeText(LauncherActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
Log.i("wwww","res="+responseBody);
                        Toast.makeText(LauncherActivity.this, responseBody.toString(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    public String sHA1() {
        try {
            PackageInfo info = this.getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            String result = hexString.toString();
            return result.substring(0, result.length() - 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
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
                        Log.i("www", "long=" + aLong);
                        //ARouter.getInstance().build("/main/tab").navigation();
                    }
                });


    }

    /**
     * 倒计时
     *
     * @param time
     * @return
     */
    public Observable<Long> countdown(final long time) {
        return Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return time - aLong;
                    }
                }).take(time + 1);
    }

}
