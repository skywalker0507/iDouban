package com.skywalker.idouban.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*******************************
 * Created by liuqiang      
 *******************************
 * data: 2017/8/21  
 ********************************/

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mPagerList=new ArrayList<>();
    private ArrayList<String> mTitleList=new ArrayList<>();

    public MyFragmentPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    public void addItem(Fragment fragment, String title){
        mPagerList.add(fragment);
        mTitleList.add(title);
    }
    @Override
    public Fragment getItem(int position) {
        return mPagerList.get(position);
    }

    @Override
    public int getCount() {
        return mPagerList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
