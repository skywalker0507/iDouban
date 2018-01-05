package com.skywalker.idouban.ui.base;

import android.view.View;

import java.util.List;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/5               *
 *******************************/

public abstract class TagAdapter<T>
{
    private List<T> mTagDatas;
    private OnDataChangedListener mOnDataChangedListener;

    public TagAdapter(List<T> datas)
    {
        mTagDatas = datas;
    }


    static interface OnDataChangedListener
    {
        void onChanged();
    }

    void setOnDataChangedListener(OnDataChangedListener listener)
    {
        mOnDataChangedListener = listener;
    }

    public int getCount()
    {
        return mTagDatas == null ? 0 : mTagDatas.size();
    }

    public void notifyDataChanged()
    {
        mOnDataChangedListener.onChanged();
    }

    public T getItem(int position)
    {
        return mTagDatas.get(position);
    }

    public abstract View getView(TagLayout parent, int position, T t);

}
