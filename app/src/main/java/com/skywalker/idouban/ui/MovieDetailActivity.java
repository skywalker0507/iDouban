package com.skywalker.idouban.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.skywalker.idouban.R;
import com.skywalker.idouban.models.movie.SimpleMovie;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/11               *
 *******************************/

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        SimpleMovie movie = (SimpleMovie)getIntent().getSerializableExtra("movie");
        ImageView image=(ImageView)findViewById(R.id.iv_movie_detail_image);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView_movie_detail_actors);
        TextView summary=(TextView)findViewById(R.id.tv_movie_detail_summary);
        summary.setText(movie.getSummary());

    }
}
