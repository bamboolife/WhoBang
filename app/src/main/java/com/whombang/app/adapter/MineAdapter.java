package com.whombang.app.adapter;

import android.content.Context;

import com.whombang.app.common.base.BaseViewHolder;
import com.whombang.app.entity.CenterEntity;

import java.util.List;

/**
 * 个人中心首页
 * Created by sundy.jiang on 2017/11/29.
 */

public class MineAdapter extends SimpleAdapter<CenterEntity>{
    public MineAdapter(Context context, List<CenterEntity> mDatas, int resId) {
        super(context, mDatas, resId);
    }

    @Override
    public void bindData(BaseViewHolder holder, CenterEntity centerEntity, int position) {

    }
}
