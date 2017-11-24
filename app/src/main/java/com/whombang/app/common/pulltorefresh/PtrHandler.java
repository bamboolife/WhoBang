package com.whombang.app.common.pulltorefresh;

public interface PtrHandler {

    /**
     * When refresh begin
     *
     * @param frame
     */
    public void onRefreshBegin(final PtrFrameLayout frame);
}