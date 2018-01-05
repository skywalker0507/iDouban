package com.skywalker.idouban.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.skywalker.idouban.R;
import com.skywalker.idouban.adapter.RecyclerViewAdapter;
import com.skywalker.idouban.models.AppItem;
import com.skywalker.idouban.ui.base.BaseFragment;
import com.skywalker.idouban.ui.base.GravitySnapHelper;
import com.skywalker.idouban.ui.base.TagAdapter;
import com.skywalker.idouban.ui.base.TagLayout;

import java.util.ArrayList;
import java.util.List;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/3               *
 *******************************/

public class BookFragment extends BaseFragment{

    public static BookFragment newInstance(int someInt, String someTitle) {
        BookFragment fragment = new BookFragment();
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

        RecyclerView recyclerView=view.findViewById(R.id.book_recommend).findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        List<AppItem> list=new ArrayList<>(10);
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        for (int i=0;i<10;i++){
            AppItem item=new AppItem("app"+i, bitmap);
            list.add(item);
        }
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        SnapHelper snapHelper = new GravitySnapHelper(GravitySnapHelper.START);
        snapHelper.attachToRecyclerView(recyclerView);

        TagLayout tagLayout=view.findViewById(R.id.book_tagLayout);
        List<String> list1=new ArrayList<>(10);
        for (int i=0;i<10;i++){
            list1.add("item "+i);
        }
        tagLayout.setAdapter(new TagAdapter<String>(list1){
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
        return R.layout.fragment_book;
    }
}
