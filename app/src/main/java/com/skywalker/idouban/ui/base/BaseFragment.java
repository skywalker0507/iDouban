package com.skywalker.idouban.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2017/12/26               *
 *******************************/

public abstract class BaseFragment extends Fragment {
    protected Activity mActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if ((context instanceof Activity)){
            this.mActivity=(Activity)context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(inflater,view, savedInstanceState);
        return view;
    }

    protected abstract void initView(LayoutInflater inflater,View view, Bundle savedInstanceState);

    protected abstract @LayoutRes int getLayoutId();
}
