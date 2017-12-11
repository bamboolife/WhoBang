package com.whombang.app.features.mycenter.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.whombang.app.R;
import com.whombang.app.adapter.ConsigneeAddressAdapter;
import com.whombang.app.common.base.BaseActivity;
import com.whombang.app.common.view.MyDivider;
import com.whombang.app.entity.ConsigneeEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 地址管理页面
 */
@Route(path = "/address/manager")
public class AddressManagerActivity extends BaseActivity {
    @BindView(R.id.rv_common_view)
    RecyclerView mRecyclerView;
    ConsigneeAddressAdapter adapter;
    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.wb_address_manage_layout;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        titleBar.setTitle("地址管理");
        adapter=new ConsigneeAddressAdapter(this,getDatas(),R.layout.wb_adress_item_layout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new MyDivider());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void doBusiness() {

    }

    private List<ConsigneeEntity> getDatas(){
        List<ConsigneeEntity> items=new ArrayList<>();
        ConsigneeEntity entity=new ConsigneeEntity();
        entity.setAddr("昌平区回龙观");
        entity.setDefault(true);
        entity.setPhone("18611766105");
        entity.setConsignee("张三");

        ConsigneeEntity entity2=new ConsigneeEntity();
        entity2.setAddr("昌平区回龙观问问");
        entity2.setDefault(false);
        entity2.setPhone("18611766105");
        entity2.setConsignee("张三1");
        items.add(entity);
        items.add(entity2);
        return items;
    }
}
