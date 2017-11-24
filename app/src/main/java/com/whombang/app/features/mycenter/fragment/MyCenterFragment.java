package com.whombang.app.features.mycenter.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.whombang.app.R;
import com.whombang.app.adapter.MyCenterAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.entity.MyCenterEntity;
import com.whombang.app.listener.BannerClickListener;
import com.whombang.app.listener.ItemOnClickListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

/**
 * 个人中心
 */
public class MyCenterFragment extends BaseFragment implements ItemOnClickListener, BannerClickListener {
    @BindView(R.id.work_recyclerview)
    RecyclerView myCenterRecyclerView;

    private VirtualLayoutManager layoutManager;
    private List<LayoutHelper> helperList;

    List<MyCenterEntity> oneFuncs;
    List<MyCenterEntity> twoFuncs;

    MyCenterAdapter workAdapter;
    @Override
    public void initData(Bundle bundle) {
           initData();
    }

    @Override
    public int bindLayout() {
        return R.layout.wb_mycenter_fgt_layout;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        layoutManager=new VirtualLayoutManager(mActivity);
        myCenterRecyclerView.setLayoutManager(layoutManager);

        //步骤2：设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool=new RecyclerView.RecycledViewPool();
        myCenterRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);
        helperList=new LinkedList<>();

        //1.
        //头部图片一项，使用SingleLayoutHelper
        SingleLayoutHelper bannerLayoutHelper = new SingleLayoutHelper();
        bannerLayoutHelper.setItemCount(1);
        helperList.add(bannerLayoutHelper);

        //2
        //个人功能大标题
        LinearLayoutHelper personTitleHelper = new LinearLayoutHelper();
        personTitleHelper.setItemCount(1);
        helperList.add(personTitleHelper);

        //功能模块，主要为九宫格
        GridLayoutHelper personGridHelper = new GridLayoutHelper(3);
        personGridHelper.setAutoExpand(false);
        personGridHelper.setWeights(new float[]{33, 33, 33});
        personGridHelper.setAspectRatio(3);
        personGridHelper.setItemCount(oneFuncs.size());
        helperList.add(personGridHelper);

        //公司功能大标题
        LinearLayoutHelper companyTitleHelper = new LinearLayoutHelper();
        companyTitleHelper.setItemCount(1);
        helperList.add(companyTitleHelper);


        //公司功能模块
        GridLayoutHelper companyGridHelper = new GridLayoutHelper(3);
        companyGridHelper.setWeights(new float[]{33, 33, 33});
        companyGridHelper.setAutoExpand(false);
        companyGridHelper.setItemCount(twoFuncs.size());
        companyGridHelper.setAspectRatio(3);
        helperList.add(companyGridHelper);

        layoutManager.setLayoutHelpers(helperList);
        workAdapter = new MyCenterAdapter(layoutManager, oneFuncs, twoFuncs, this, this);

        myCenterRecyclerView.setAdapter(workAdapter);
    }

    @Override
    public void doBusiness() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(View view, int postion) {

    }
    private void initData() {
        oneFuncs = new ArrayList<>();
        twoFuncs = new ArrayList<>();


        for (int i = 0; i < 8; i++) {
            oneFuncs.add(new MyCenterEntity("私人服务", R.mipmap.home));
            twoFuncs.add(new MyCenterEntity("公司服务", R.mipmap.person));
        }
    }

}
