package com.skywalker.idouban.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

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

    private TextView mTextView;

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
        /*final List<TagItem<String>> list=new ArrayList<>(6);
        list.add(new TagItem<String>("豆瓣电影Top 250","/v2/movie/top250"));
        list.add(new TagItem<String>("正在热映","/v2/movie/in_theaters"));
        list.add(new TagItem<String>("即将上映","/v2/movie/coming_soon"));
        list.add(new TagItem<String>("口碑榜","/v2/movie/weekly"));
        list.add(new TagItem<String>("北美票房榜","/v2/movie/us_box"));
        list.add(new TagItem<String>("新片榜","/v2/movie/new_movies"));*/


        final List<String> list=new ArrayList<>(6);
        list.add("豆瓣电影Top 250");
        list.add("正在热映");
        list.add("即将上映");
        list.add("口碑榜");
        list.add("北美票房榜");
        list.add("新片榜");



        tagLayout.setAdapter(new TagAdapter<String>(list){

            @Override
            public View getView(TagLayout parent, int position, String item) {
                TextView tv = (TextView) inflater.inflate(R.layout.tag_movie,
                        parent, false);
                tv.setText(item);
                return tv;
            }
        });
        tagLayout.setOnTagClickListener(new TagLayout.TagClickListener() {
            @Override
            public void onTagClick(TagLayout parent, View view, int position) {
                Intent intent;
                switch (position){
                    case 0:
                        intent=new Intent(getActivity(),Top250MovieActivity.class);
                        break;
                        default:
                            intent=new Intent(getActivity(),Top250MovieActivity.class);
                }

                intent.putExtra("tag",list.get(position));
                /*ActivityOptionsCompat options = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(getActivity(), view, "movie_tag");*/
                startActivity(intent);



            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_movie;
    }
}
