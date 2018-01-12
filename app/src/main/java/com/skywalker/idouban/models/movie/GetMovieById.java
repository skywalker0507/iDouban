package com.skywalker.idouban.models.movie;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/12               *
 *******************************/

public interface GetMovieById {
    @GET("movie/subject/{id}")
    Observable<ResponseBody> response(@Path("id") String id);
}
