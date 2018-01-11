package com.skywalker.idouban.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.google.gson.Gson;
import com.skywalker.idouban.R;
import com.skywalker.idouban.models.movie.Movie;
import com.skywalker.idouban.models.movie.MovieAdapter;
import com.skywalker.idouban.models.movie.SimpleMovie;
import com.skywalker.idouban.models.movie.Top250;
import com.skywalker.idouban.models.movie.Top250Movie;
import com.skywalker.idouban.ui.base.SwipeRefreshLayoutEx;

import java.util.ArrayList;
import java.util.Arrays;
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
 * data: 2018/1/10               *
 *******************************/

public class Top250MovieActivity extends AppCompatActivity implements SwipeRefreshLayoutEx.OnRefreshListener,MovieAdapter.OnItemClickListener {


    private SwipeRefreshLayoutEx mRefreshLayout;
    private List<Movie> list = new ArrayList<>();
    private MovieAdapter adapter;
    private int start = 0;
    private static final int COUNT = 10;
    final String baseUrl = "https://api.douban.com/v2/";

    private Retrofit retrofit;
    private Top250Movie movie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top250movie);
        initView();
        String title = getIntent().getStringExtra("tag");
        initToolbar(title);
        ProgressDialog dialog=new ProgressDialog(this);
        getData(dialog);

    }

    private void initView(){
        RecyclerView recyclerView = findViewById(R.id.rv_movie_main);
        mRefreshLayout = findViewById(R.id.SwipeRefreshLayout_top250);
        mRefreshLayout.setPullPosition(Gravity.BOTTOM);
        mRefreshLayout.setRefreshDrawableStyle(SwipeRefreshLayoutEx.ARROW);
        mRefreshLayout.setOnRefreshListener(this);
        adapter = new MovieAdapter(this, list);
        adapter.setOnItemClickListener(this);
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        movie = retrofit.create(Top250Movie.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    private void initToolbar(String title) {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(title);
        setSupportActionBar(mToolbar);

    }

    @Override
    public void onRefresh() {
        getData(null);
    }

    private void getData(@Nullable final ProgressDialog dialog) {
        if (dialog!=null){
            dialog.show();
        }
        movie.response(start, COUNT)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, Top250>() {
                    @Override
                    public Top250 apply(ResponseBody responseBody) throws Exception {
                        Gson gson = new Gson();
                        return gson.fromJson(responseBody.string(), Top250.class);
                    }
                })
                .subscribe(new Observer<Top250>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Top250 movies) {
                        Log.e("movie", String.valueOf(movies.getSubjects().length));
                        list.addAll(Arrays.asList(movies.getSubjects()));
                        adapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError", e.getMessage());
                        mRefreshLayout.setRefreshing(false);
                        if (dialog!=null){
                            dialog.dismiss();
                        }
                    }

                    @Override
                    public void onComplete() {
                        start += COUNT;
                        mRefreshLayout.setRefreshing(false);
                        if (dialog!=null){
                            dialog.dismiss();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view, int position, Movie movie) {
        Intent intent=new Intent(this,MovieDetailActivity.class);
        intent.putExtra("movie",new SimpleMovie(movie));
        startActivity(intent);
    }
}
