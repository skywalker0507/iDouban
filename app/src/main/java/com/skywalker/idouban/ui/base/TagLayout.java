package com.skywalker.idouban.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/5               *
 *******************************/

public class TagLayout extends HorizontalScrollView {

    private final LinearLayout mTagStrip;
    private TagClickListener mListener;
    private final static int MARGIN_LEFT = 5;
    private final static int MARGIN_RIGHT = 5;
    private final static int MARGIN_TOP = 3;
    private final static int MARGIN_BOTTOM = 3;

    public TagLayout(Context context) {
        this(context, null);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setHorizontalScrollBarEnabled(false);
        mTagStrip = new LinearLayout(context);
        super.addView(mTagStrip, 0, new HorizontalScrollView.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT));

    }

    public void setAdapter(TagAdapter adapter) {
        for (int i = 0; i < adapter.getCount(); i++) {
            final int position = i;
            View view = adapter.getView(this, position, adapter.getItem(position));
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onTagClick(TagLayout.this, v, position);
                    }
                }
            });

            addTabView(view, i);
        }
    }

    public void setOnTagClickListener(TagClickListener listener) {
        this.mListener = listener;
    }

    private void addTabView(View view, int index) {
        int h=dip2px(getContext(),5);
        int w=dip2px(getContext(),10);
        view.setPadding(w,h,w,h);

        MarginLayoutParams lp = new MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(dip2px(getContext(), MARGIN_LEFT),
                dip2px(getContext(), MARGIN_TOP),
                dip2px(getContext(), MARGIN_RIGHT),
                dip2px(getContext(), MARGIN_BOTTOM));
        view.setLayoutParams(lp);
        mTagStrip.addView(view, index, lp);


    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


    public interface TagClickListener {
        void onTagClick(TagLayout parent, View view, int position);
    }


}
