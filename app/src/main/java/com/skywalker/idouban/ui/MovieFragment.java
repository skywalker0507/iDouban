package com.skywalker.idouban.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.skywalker.idouban.R;
import com.skywalker.idouban.ui.base.BaseFragment;
import com.skywalker.idouban.ui.base.TagAdapter;
import com.skywalker.idouban.ui.base.TagLayout;

import java.util.ArrayList;
import java.util.List;

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
    protected void initView(final LayoutInflater inflater, View view, Bundle savedInstanceState) {
        TagLayout tagLayout=view.findViewById(R.id.movie_tagLayout);
        List<String> list=new ArrayList<>(10);
        for (int i=0;i<10;i++){
            list.add("item "+i);
        }
        tagLayout.setAdapter(new TagAdapter<String>(list){
            @Override
            public View getView(TagLayout parent, int position, String s) {
                TextView tv = (TextView) inflater.inflate(R.layout.tv,
                        parent, false);
                tv.setText(s);
                return tv;
            }
        });
        tagLayout.setOnTagClickListener(new TagLayout.TagClickListener() {
            @Override
            public void onTagClick(TagLayout parent, View view, int position) {
                Toast.makeText(getContext(),"hello",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie;
    }
}
