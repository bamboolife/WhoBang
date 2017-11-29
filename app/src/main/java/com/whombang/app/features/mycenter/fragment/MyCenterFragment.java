package com.whombang.app.features.mycenter.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.sunfusheng.marqueeview.MarqueeView;
import com.whombang.app.R;
import com.whombang.app.adapter.BaseDelegateAdapter;
import com.whombang.app.adapter.MyCenterAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.common.entity.MyCenterEntity;
import com.whombang.app.entity.CenterEntity;
import com.whombang.app.listener.BannerClickListener;
import com.whombang.app.listener.ItemOnClickListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

import static com.whombang.app.features.home.fragment.HomeFragment.Config.NEWS_VIEW_TYPE;
import static com.whombang.app.features.shop.fragment.ShopFragment.Config.GRID_VIEW_TYPE;


/**
 * 个人中心
 */
public class MyCenterFragment extends BaseFragment {
    private static final int TYPE_VIEW_HEAD=0;
    private static final int TYPE_VIEW_LIST=1;
    private static final int TYPE_VIEW_BOTTOM=2;
    @BindView(R.id.work_recyclerview)
    RecyclerView mRecyclerView;
    List<CenterEntity> entityList;
    private VirtualLayoutManager layoutManager;
    private List<DelegateAdapter.Adapter> mAdapters; //存放各个模块的适配器

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
        mAdapters = new LinkedList<>();
        layoutManager = new VirtualLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(layoutManager);

        //步骤2：设置组件复用回收池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        //1头部
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        mRecyclerView.setAdapter(delegateAdapter);

        BaseDelegateAdapter headAdapter = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper()
                , R.layout.item_work_banner, 1, TYPE_VIEW_HEAD) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);

            }
        };
        mAdapters.add(headAdapter);
        //2功能列表
        BaseDelegateAdapter functionAdapter = new BaseDelegateAdapter(mActivity,  new LinearLayoutHelper(), R.layout.item_work_func
                , 7, GRID_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                 TextView tvName=holder.getView(R.id.function_name);
                 View line=holder.getView(R.id.my_line);
                 View line_top=holder.getView(R.id.my_line_top);
                 tvName.setText(entityList.get(position).name);
                 if (entityList.get(position).isShowBottom){
                     line.setVisibility(View.VISIBLE);
                 }else{
                     line.setVisibility(View.GONE);
                 }
                 if (entityList.get(position).isShowTop){
                     line_top.setVisibility(View.VISIBLE);
                 }else{
                     line_top.setVisibility(View.GONE);
                 }
                 holder.getConvertView().setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         switch (position){
                             case 0:
                                 ARouter.getInstance().build("/order/service").navigation();
                                 break;
                             case 1:
                                 ARouter.getInstance().build("/order/shop").navigation();
                                 break;
                             case 2:
                                 ARouter.getInstance().build("/my/evaluate").navigation();
                                 break;

                             case 3:
                                 ARouter.getInstance().build("/my/station").navigation();
                                 break;

                             case 4:
                                 ARouter.getInstance().build("/my/userinformation").navigation();
                                 break;

                             case 5:
                                 ARouter.getInstance().build("/my/setting").navigation();
                                 break;

                             case 6:
                                 ARouter.getInstance().build("/my/about").navigation();
                                 break;
                         }
                     }
                 });

            }

        };
        mAdapters.add(functionAdapter);
        //设置适配器
        delegateAdapter.setAdapters(mAdapters);
    }

    @Override
    public void doBusiness() {

    }
    /**
     * 添加本地数据
     */
    private void initData() {
        entityList=new LinkedList<>();
        CenterEntity entity0=new CenterEntity(getString(R.string.my_service_order),true,false);
        CenterEntity entity1=new CenterEntity(getString(R.string.my_shop_order),false,false);
        CenterEntity entity2=new CenterEntity(getString(R.string.my_evaluate),false,false);
        CenterEntity entity3=new CenterEntity(getString(R.string.my_station),true,true);
        CenterEntity entity4=new CenterEntity(getString(R.string.my_user_information),false,false);
        CenterEntity entity5=new CenterEntity(getString(R.string.my_setting),false,false);
        CenterEntity entity6=new CenterEntity(getString(R.string.my_about),false,false);
         entityList.add(entity0);
         entityList.add(entity1);
         entityList.add(entity2);
         entityList.add(entity3);
         entityList.add(entity4);
         entityList.add(entity5);
         entityList.add(entity6);
    }

}
