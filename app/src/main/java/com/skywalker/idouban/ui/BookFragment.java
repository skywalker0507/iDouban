package com.skywalker.idouban.ui;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.skywalker.idouban.R;
import com.skywalker.idouban.adapter.RecyclerViewAdapter;
import com.skywalker.idouban.models.AppItem;
import com.skywalker.idouban.models.movie.Top250;
import com.skywalker.idouban.models.movie.Top250Movie;
import com.skywalker.idouban.ui.base.BaseFragment;
import com.skywalker.idouban.ui.base.GravitySnapHelper;
import com.skywalker.idouban.ui.base.TagAdapter;
import com.skywalker.idouban.ui.base.TagLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/3               *
 *******************************/

public class BookFragment extends BaseFragment {

    private static final String TAG  = "BookFragment";
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

        final RecyclerView recyclerView = view.findViewById(R.id.book_recommend).findViewById(R.id.recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        List<AppItem> list = new ArrayList<>(10);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        for (int i = 0; i < 10; i++) {
            AppItem item = new AppItem("app" + i, bitmap);
            list.add(item);
        }
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), list);
        recyclerView.setAdapter(adapter);
        SnapHelper snapHelper = new GravitySnapHelper(GravitySnapHelper.START);
        snapHelper.attachToRecyclerView(recyclerView);

        TagLayout tagLayout = view.findViewById(R.id.book_tagLayout);
        List<String> list1 = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list1.add("item " + i);
        }
        tagLayout.setAdapter(new TagAdapter<String>(list1) {
            @Override
            public View getView(TagLayout parent, int position, String s) {
                TextView tv = (TextView) inflater.inflate(R.layout.tag_book,
                        parent, false);
                tv.setText(s);
                return tv;
            }
        });
        tagLayout.setOnTagClickListener(new TagLayout.TagClickListener() {
            @Override
            public void onTagClick(TagLayout parent, View view, int position) {
                Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
            }
        });


        Button button = (Button) view.findViewById(R.id.book_bt_test);
        final String baseUrl = "https://api.douban.com/v2/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            ProgressDialog mDialog=new ProgressDialog(getContext());
            @Override
            public void onClick(View v) {
                mDialog.show();
                /*GetBookInfoByISBN book = retrofit.create(GetBookInfoByISBN.class);
                book.response("9787115346421")
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new Function<ResponseBody, Book>() {
                            @Override
                            public Book apply(ResponseBody responseBody) throws Exception {
                                Gson gson = new Gson();
                                return gson.fromJson(responseBody.string(), Book.class);
                            }
                        }).subscribe(new Observer<Book>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(Book book) {
                        Log.e(TAG,"onNext");
                        Log.e("book", book.getTitle());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError");
                        if (e instanceof HttpException){
                            int code=((HttpException) e).code();
                            if (code==404||code==400){
                                Toast.makeText(getContext(),"未找到！",Toast.LENGTH_SHORT).show();
                            }
                        }
                        mDialog.dismiss();
                    }

                    @Override
                    public void onComplete() {
                        mDialog.dismiss();
                    }
                });*/

                Top250Movie top=retrofit.create(Top250Movie.class);
                top.response(0,10).subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(new Function<ResponseBody, Top250>() {
                            @Override
                            public Top250 apply(ResponseBody responseBody) throws Exception {
                                Gson gson=new Gson();
                                return gson.fromJson(responseBody.string(),Top250.class);
                            }
                        })
                        .subscribe(new Observer<Top250>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Top250 movies) {
                                Log.e("movie", String.valueOf(movies.getSubjects().length));
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e("onError",e.getMessage());
                                mDialog.dismiss();
                            }

                            @Override
                            public void onComplete() {
                                mDialog.dismiss();
                            }
                        });
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_book;
    }
}
