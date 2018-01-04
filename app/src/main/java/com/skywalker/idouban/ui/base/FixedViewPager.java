package com.skywalker.idouban.ui.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/4               *
 *******************************/

public class FixedViewPager extends ViewPager {
    private boolean mScrollable=true;
    public FixedViewPager(Context context) {
        super(context);
    }

    public FixedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void canScroll(boolean scrollable){
        this.mScrollable=scrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.mScrollable && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.mScrollable && super.onInterceptTouchEvent(event);
    }
}
