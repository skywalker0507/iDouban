package com.skywalker.idouban.ui;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.skywalker.idouban.R;
import com.skywalker.idouban.adapter.MyFragmentPagerAdapter;
import com.skywalker.idouban.ui.base.BaseFragment;
import com.skywalker.idouban.ui.base.FixedViewPager;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/3               *
 *******************************/

public class MainFragment extends BaseFragment {


    private FixedViewPager mViewPager;
    private MyFragmentPagerAdapter mAdapter;
    private Animator mAnimator;
    private long ANIMATION_DURATION = 650L;

    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    private int mAppBarHeight;
    private int mAppBarWidth;
    private int mTabCount;

    private static final String KEY_INT  = "int";
    private static final String KEY_STRING="string";
    private static final String TAG  = "MainFragment";
    private int mSelectItem;
    public static MainFragment newInstance(int selectedItem, String someTitle) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_INT, selectedItem);
        args.putString(KEY_STRING, someTitle);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get back arguments
        mSelectItem = getArguments().getInt(KEY_INT, 0);
        String someTitle = getArguments().getString(KEY_STRING, "");
        Log.e(TAG,"onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mViewPager = (FixedViewPager) view.findViewById(R.id.main_viewPager);
        mViewPager.canScroll(false);
        BookFragment fragment1 = BookFragment.newInstance(0, "book");
        MusicFragment fragment2 = MusicFragment.newInstance(1, "music");
        MovieFragment fragment3 = MovieFragment.newInstance(2, "movie");
        mAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
        mAdapter.addItem(fragment1, "图书", ContextCompat.getColor(getContext(), R.color.bookBackground));
        mAdapter.addItem(fragment2, "音乐", ContextCompat.getColor(getContext(), R.color.musicBackground));
        mAdapter.addItem(fragment3, "电影", ContextCompat.getColor(getContext(), R.color.movieBackground));
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(mSelectItem);
        mAppBarLayout = (AppBarLayout) view.findViewById(R.id.appBarLayout);
        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        final NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        mAppBarLayout.post(new Runnable() {
            @Override
            public void run() {
                mAppBarHeight =mAppBarLayout.getHeight();
                mAppBarWidth=mAppBarLayout.getWidth();
            }
        });

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                mTabCount=tabLayout.getTabCount();

            }
        });



        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    navigationView.setCheckedItem(R.id.nav_book);

                } else if (position == 1) {
                    navigationView.setCheckedItem(R.id.nav_music);
                }
                int x=(mAppBarWidth/mTabCount/2)*(2*position+1);
                animate(x,mAppBarHeight,mAdapter.getItemBackground(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ImageView toggle = (ImageView) mToolbar.findViewById(R.id.toggle);
        toggle.setImageDrawable(new DrawerArrowDrawable(getContext()));
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);

            }
        });


    }


    private void animate(int x, int y, final int color) {
        float startRadius = 0F;
        float endRadius = (float) Math.hypot(mAppBarLayout.getWidth(), mAppBarLayout.getHeight());
        if (mAnimator != null) {
            mAnimator.cancel();
        }

        mAnimator = ViewAnimationUtils.createCircularReveal(mAppBarLayout, x, y, startRadius, endRadius);
        mAnimator.setDuration(ANIMATION_DURATION);
        mAnimator.setInterpolator(new FastOutSlowInInterpolator());

        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                setBackground(color);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mAnimator.start();

    }

    private void setBackground(int color) {
        mToolbar.setBackgroundColor(color);
        mAppBarLayout.setBackgroundColor(color);
        mDrawerLayout.setStatusBarBackgroundColor(color);
    }


    public void selectItem(int index) {
        if (index < 0 || index > mAdapter.getCount() - 1) {
            throw new IllegalArgumentException("index 范围错误");
        }
        mViewPager.setCurrentItem(index);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }
}
