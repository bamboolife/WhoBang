package com.whombang.app.common.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Description:fragment的基类 注意：除非特殊，要不必须继承
 * Company:
 * Created by sundy.jiang on 2017/11/10.
 */

public abstract class BaseFragment extends Fragment implements IBaseView{
    private String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    /**
     * 当前Fragment渲染的视图View
     */
    protected View contentView;

    protected Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            boolean isSupportHidden=savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            if (isSupportHidden){
                ft.hide(this);
            }else{
                ft.show(this);
            }
            ft.commit();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView=inflater.inflate(bindLayout(),null);
        ButterKnife.bind(this,contentView);
        return contentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle=getArguments();
        initData(bundle);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity=getActivity();
        initView(savedInstanceState,contentView);
        doBusiness();
    }

    @Override
    public void onDestroyView() {
        if (contentView!=null){
            ((ViewGroup)contentView.getParent()).removeView(contentView);
        }
        super.onDestroyView();
    }

    /**
     * 保存状态
     * @param outState
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN,isHidden());
    }
}
