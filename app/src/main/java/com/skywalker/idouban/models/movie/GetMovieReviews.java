package com.skywalker.idouban.models.movie;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/12               *
 *******************************/

public interface GetMovieReviews {
    @GET("movie/subject/{id}/reviews")
    Observable<ResponseBody> response(@Path("id")int id, @Query("start") int start, @Query("count")int count);
}
