package com.whombang.app.features.service.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.whombang.app.R;
import com.whombang.app.adapter.BaseDelegateAdapter;
import com.whombang.app.adapter.SpikeContentAdapter;
import com.whombang.app.common.base.BaseFragment;
import com.whombang.app.common.baseadapter.BaseViewHolder;
import com.whombang.app.common.utils.GlideImageLoader;
import com.whombang.app.entity.ServiceEntity;
import com.whombang.app.entity.TitleEntity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

import static com.whombang.app.adapter.MyCenterAdapter.BANNER_VIEW_TYPE;
import static com.whombang.app.adapter.MyCenterAdapter.DIVIDER_VIEW_TYPE;
import static com.whombang.app.adapter.MyCenterAdapter.FUN_VIEW_TYPE;
import static com.whombang.app.features.home.fragment.HomeFragment.Config.GRID_URL;
import static com.whombang.app.features.home.fragment.HomeFragment.Config.GRID_VIEW_TYPE;

/**
 * 服务首页
 */
public class ServiceFragment extends BaseFragment {
    @BindView(R.id.service_recyclerview)
    RecyclerView mRecyclerView;
    private VirtualLayoutManager layoutManager;
    private List<DelegateAdapter.Adapter> mAdapters; //存放各个模块的适配器
    private List<TitleEntity> titleData;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_service_fragment_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        mAdapters = new LinkedList<>();
        //初始化
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(mActivity);
        mRecyclerView.setLayoutManager(layoutManager);
        //设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）：
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        mRecyclerView.setAdapter(delegateAdapter);

        //banner
        BaseDelegateAdapter bannerAdapter = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper()
                , R.layout.vlayout_banner, 1, BANNER_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("http://bpic.wotucdn.com/11/66/23/55bOOOPIC3c_1024.jpg!/fw/780/quality/90/unsharp/true/compress/true/watermark/url/L2xvZ28ud2F0ZXIudjIucG5n/repeat/true");
                arrayList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1505470629546&di=194a9a92bfcb7754c5e4d19ff1515355&imgtype=0&src=http%3A%2F%2Fpics.jiancai.com%2Fimgextra%2Fimg01%2F656928666%2Fi1%2FT2_IffXdxaXXXXXXXX_%2521%2521656928666.jpg");
                // 绑定数据
                Banner mBanner = holder.getView(R.id.banner);
                //设置banner样式
                mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置图片加载器
                mBanner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                mBanner.setImages(arrayList);
                //设置banner动画效果
                mBanner.setBannerAnimation(Transformer.DepthPage);
                //设置标题集合（当banner样式有显示title时）
                //        mBanner.setBannerTitles(titles);
                //设置自动轮播，默认为true
                mBanner.isAutoPlay(true);
                //设置轮播时间
                mBanner.setDelayTime(5000);
                //设置指示器位置（当banner模式中有指示器时）
                mBanner.setIndicatorGravity(BannerConfig.CENTER);
                //banner设置方法全部调用完毕时最后调用
                mBanner.start();

                mBanner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(mActivity, "banner点击了" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        //把轮播器添加到集合
        mAdapters.add(bannerAdapter);
        LinearLayoutHelper titleLayoutHelper = new LinearLayoutHelper();
        titleLayoutHelper.setMargin(0, 10, 0, 10);

        BaseDelegateAdapter titleAdapter = new BaseDelegateAdapter(mActivity, titleLayoutHelper
                , R.layout.title_view, 1, DIVIDER_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
              TextView title= holder.getView(R.id.title_name);
              title.setText("精选服务");
              ImageView img=holder.getView(R.id.title_image);
              img.setImageResource(R.mipmap.title_image1);
            }
        };
        mAdapters.add(titleAdapter);

        BaseDelegateAdapter serviceAdapter = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper()
                , R.layout.wb_service_spike_content_layout, 1, FUN_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
               RecyclerView recyclerView=holder.getView(R.id.spike_content_view);
               recyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
               List<ServiceEntity> entities=new LinkedList<>();
                for (int i = 0; i < 10; i++) {
                    ServiceEntity entity=new ServiceEntity();
                    entities.add(entity);
                }
                SpikeContentAdapter adapter = new SpikeContentAdapter(R.layout.homerecycle_item_spike_content, entities);
                recyclerView.setAdapter(adapter);
                }

        };
        mAdapters.add(serviceAdapter);
        //服务列表
        BaseDelegateAdapter serviceListAdapter = new BaseDelegateAdapter(mActivity,  new LinearLayoutHelper(), R.layout.vlayout_grid
                , 12, GRID_VIEW_TYPE) {
            @Override
            public void onBindViewHolder(BaseViewHolder holder, final int position) {
                super.onBindViewHolder(holder, position);
                int item = GRID_URL[position];
                ImageView iv = holder.getView(R.id.iv);
                Glide.with(mActivity).load(item).into(iv);

                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mActivity, "item" + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        mAdapters.add(serviceListAdapter);
//        LinearLayoutHelper titleLayoutHelper2 = new LinearLayoutHelper();
//        titleLayoutHelper2.setMargin(0, 10, 0, 10);
//
//        BaseDelegateAdapter titleAdapter2 = new BaseDelegateAdapter(mActivity, titleLayoutHelper2
//                , R.layout.title_view, 1, DIVIDER_VIEW_TYPE) {
//            @Override
//            public void onBindViewHolder(BaseViewHolder holder, int position) {
//                super.onBindViewHolder(holder, position);
//                TextView title= holder.getView(R.id.title_name);
//                title.setText("维修");
//                ImageView img=holder.getView(R.id.title_image);
//                img.setImageResource(R.mipmap.title_image1);
//            }
//        };
//        mAdapters.add(titleAdapter2);
//
//        BaseDelegateAdapter serviceAdapter2 = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper()
//                , R.layout.wb_service_spike_content_layout, 1, FUN_VIEW_TYPE) {
//            @Override
//            public void onBindViewHolder(BaseViewHolder holder, int position) {
//                super.onBindViewHolder(holder, position);
//                RecyclerView recyclerView=holder.getView(R.id.spike_content_view);
//                recyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
//                List<ServiceEntity> entities=new LinkedList<>();
//                for (int i = 0; i < 10; i++) {
//                    ServiceEntity entity=new ServiceEntity();
//                    entities.add(entity);
//                }
//                SpikeContentAdapter adapter = new SpikeContentAdapter(R.layout.homerecycle_item_spike_content, entities);
//                recyclerView.setAdapter(adapter);
//            }
//
//        };
//        mAdapters.add(serviceAdapter2);
//        LinearLayoutHelper titleLayoutHelper3 = new LinearLayoutHelper();
//        titleLayoutHelper2.setMargin(0, 10, 0, 10);
//
//        BaseDelegateAdapter titleAdapter3 = new BaseDelegateAdapter(mActivity, titleLayoutHelper3
//                , R.layout.title_view, 1, DIVIDER_VIEW_TYPE) {
//            @Override
//            public void onBindViewHolder(BaseViewHolder holder, int position) {
//                super.onBindViewHolder(holder, position);
//                TextView title= holder.getView(R.id.title_name);
//                title.setText("法律咨询");
//                ImageView img=holder.getView(R.id.title_image);
//                img.setImageResource(R.mipmap.title_image1);
//            }
//        };
//        mAdapters.add(titleAdapter3);
//
//        BaseDelegateAdapter serviceAdapter3 = new BaseDelegateAdapter(mActivity, new LinearLayoutHelper()
//                , R.layout.wb_service_spike_content_layout, 1, FUN_VIEW_TYPE) {
//            @Override
//            public void onBindViewHolder(BaseViewHolder holder, int position) {
//                super.onBindViewHolder(holder, position);
//                RecyclerView recyclerView=holder.getView(R.id.spike_content_view);
//                recyclerView.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
//                List<ServiceEntity> entities=new LinkedList<>();
//                for (int i = 0; i < 10; i++) {
//                    ServiceEntity entity=new ServiceEntity();
//                    entities.add(entity);
//                }
//                SpikeContentAdapter adapter = new SpikeContentAdapter(R.layout.homerecycle_item_spike_content, entities);
//                recyclerView.setAdapter(adapter);
//            }
//
//        };
//        mAdapters.add(serviceAdapter3);
        //设置适配器
        delegateAdapter.setAdapters(mAdapters);
    }

    @Override
    public void doBusiness() {

    }
}
