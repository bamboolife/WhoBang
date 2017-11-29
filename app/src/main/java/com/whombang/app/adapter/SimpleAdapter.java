package com.whombang.app.adapter;

import android.content.Context;

import com.whombang.app.common.base.BaseAdapter;
import com.whombang.app.common.base.BaseViewHolder;

import java.util.List;

/**
 * 简单的adapter的抽象类
 */

public abstract class SimpleAdapter<T> extends BaseAdapter< T , BaseViewHolder> {

    public SimpleAdapter(Context context, List<T> mDatas, int resId) {
        super(context, mDatas, resId);
    }
    
}
