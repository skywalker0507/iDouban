package com.skywalker.idouban.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.skywalker.idouban.R;
import com.skywalker.idouban.adapter.MyFragmentPagerAdapter;
import com.skywalker.idouban.ui.base.BaseFragment;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/3               *
 *******************************/

public class MainFragment extends BaseFragment {

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        ViewPager viewPager=view.findViewById(R.id.main_viewPager);
        BookFragment fragment1 = new BookFragment();
        MusicFragment fragment2 =new  MusicFragment();
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        adapter.addItem(fragment1, "图书");
        adapter.addItem(fragment2, "音乐");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout=view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }
}
