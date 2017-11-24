package com.whombang.app.entity;

/**
 * 分组title的实体
 * Created by sundy.jiang on 2017/11/23.
 */

public class TitleEntity {
    public String titleName;
    public int titelImage;
    public int titleColor;

    public TitleEntity(String titleName, int titelImage) {
        this(titleName, titelImage, 0);
    }

    public TitleEntity(String titleName, int titelImage, int titleColor) {
        this.titleName = titleName;
        this.titelImage = titelImage;
        this.titleColor = titleColor;
    }
}
