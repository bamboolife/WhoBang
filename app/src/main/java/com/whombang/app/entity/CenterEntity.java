package com.whombang.app.entity;

/**
 * 个人中心实体
 * Created by sundy.jiang on 2017/11/28.
 */

public class CenterEntity {
     public String  name;
     public boolean isShowBottom;
     public boolean isShowTop;

    public CenterEntity(String name, boolean isShowTop,boolean isShowBottom) {
        this.name = name;
        this.isShowBottom = isShowBottom;
        this.isShowTop=isShowTop;
    }
}
