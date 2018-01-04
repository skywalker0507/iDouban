package com.skywalker.idouban.ui;

import android.os.Bundle;
import android.view.View;

import com.skywalker.idouban.R;
import com.skywalker.idouban.ui.base.BaseFragment;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/4               *
 *******************************/

public class MovieFragment extends BaseFragment {

    public static MovieFragment newInstance(int someInt, String someTitle) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", someInt);
        args.putString("someTitle", someTitle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get back arguments
        int SomeInt = getArguments().getInt("someInt", 0);
        String someTitle = getArguments().getString("someTitle", "");
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_moive;
    }
}
