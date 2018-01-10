package com.skywalker.idouban.models.movie;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/9               *
 *******************************/

public interface NewMovies {
    @GET("movie/new_movies")
    Observable<ResponseBody> response();
}
