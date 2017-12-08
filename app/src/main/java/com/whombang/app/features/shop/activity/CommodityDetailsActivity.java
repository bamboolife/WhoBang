package com.whombang.app.features.shop.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gxz.PagerSlidingTabStrip;
import com.whombang.app.R;
import com.whombang.app.adapter.ItemTitlePagerAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.features.shop.fragment.GoodsCommentFragment;
import com.whombang.app.features.shop.fragment.GoodsDetailFragment;
import com.whombang.app.features.shop.fragment.GoodsInfoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 商品详情页
 */
@Route(path = "/shop/details")
public class CommodityDetailsActivity extends BaseActivity {
    @BindView(R.id.psts_tabs)
    PagerSlidingTabStrip tabStrip;
    @BindView(R.id.vp_content)
    ViewPager viewPager;
    private List<Fragment> fragmentList;

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_commodity_details;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        fragmentList = new ArrayList<>();
        fragmentList.add(new GoodsInfoFragment());
        fragmentList.add(new GoodsDetailFragment());
        fragmentList.add(new GoodsCommentFragment());
        viewPager.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(), fragmentList, new String[]{"商品", "详情", "评价"}));
        viewPager.setOffscreenPageLimit(3);
        tabStrip.setViewPager(viewPager);

    }
    @OnClick(R.id.imgBack)
    public void onImageViewBack(){
        finish();
    }
    @Override
    public void doBusiness() {

    }
}
