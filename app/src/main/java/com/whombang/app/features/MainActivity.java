package com.whombang.app.features;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.whombang.app.R;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.systembar.SystemBarManager;
import com.whombang.app.common.view.popupwindow.PopMenuView;
import com.whombang.app.common.view.tabbar.NavigateTabBar;
import com.whombang.app.features.home.fragment.HomeFragment;
import com.whombang.app.features.mycenter.fragment.MyCenterFragment;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.PermissionYes;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/main/tab")
public class MainActivity extends BaseActivity {
    private static final int REQUEST_CODE_PERMISSION_MULTI = 101;
    /**
     * 底部导航控制器
     */
    @BindView(R.id.main_tabbar)
    NavigateTabBar mNavigateTabBar;
    /**
     * 呼叫器tab键
     */
    @BindView(R.id.fab_call)
    ImageView fabCall;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_main_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        SystemBarManager.translucentStatusBar(this,false);
        titleBar.setVisibility(View.GONE);
        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);
        mNavigateTabBar.addTab(HomeFragment.class, new NavigateTabBar.TabParam(R.mipmap.navigate_tab_home, R.mipmap.navigate_tab_home_selected, getString(R.string.tab_txt_home)));
       // mNavigateTabBar.addTab(ShopFragment.class, new NavigateTabBar.TabParam(R.mipmap.navigate_tab_shop, R.mipmap.navigate_tab_shop_selected, getString(R.string.tab_txt_shop)));
        mNavigateTabBar.addTab(null, new NavigateTabBar.TabParam(0, 0, ""));
      //  mNavigateTabBar.addTab(ServiceFragment.class, new NavigateTabBar.TabParam(R.mipmap.navigate_tab_service, R.mipmap.navigate_tab_service_selected, getString(R.string.tab_txt_service)));
        mNavigateTabBar.addTab(MyCenterFragment.class, new NavigateTabBar.TabParam(R.mipmap.navigate_tab_my, R.mipmap.navigate_tab_my_selected, getString(R.string.tab_txt_my)));

    }

    @OnClick(R.id.fab_call)
    public void onBeeper() {
        PopMenuView.getInstance().show(MainActivity.this, fabCall);
        PopMenuView.getInstance().setListener(new PopMenuView.PopupMenuListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onPopupMenu(int position) {
                switch (position) {
                    case 1:
//                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10010"));
//                        startActivity(intent);
                        ARouter.getInstance().build("/task/phone").navigation();
                      break;
                  case 2:
                      ARouter.getInstance().build("/task/voice").navigation();
                      break;
                  case 3:
                      ARouter.getInstance().build("/task/text").navigation();
                      break;
                    default:
              }
            }
        });
    }
    @Override
    public void doBusiness() {
      requestPermission();
    }

    /**
     * 请求权限
     */
    private void requestPermission() {
        AndPermission.with(this)
           .requestCode(REQUEST_CODE_PERMISSION_MULTI)
                .permission(Permission.PHONE,Permission.STORAGE,Permission.MICROPHONE,Permission.CONTACTS)
                .callback(this)
                .start();

    }

    @Override
    public void onBackPressed() {
        // 当popupWindow 正在展示的时候 按下返回键 关闭popupWindow 否则关闭activity
        if (PopMenuView.getInstance().isShowing()) {
            PopMenuView.getInstance().closePopupWindowAction();
        }
        else {
            super.onBackPressed();
        }
    }

    /**
     * 保存状态
     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }

    @PermissionYes(REQUEST_CODE_PERMISSION_MULTI)
    private void getSingleYes(@NonNull List<String> grantedPermissions) {

    }

    @PermissionYes(REQUEST_CODE_PERMISSION_MULTI)
    private void getSingleNo(@NonNull List<String> deniedPermissions) {

    }

}
