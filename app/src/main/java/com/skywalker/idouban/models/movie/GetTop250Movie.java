package com.skywalker.idouban.models.movie;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/9               *
 *******************************/

public interface GetTop250Movie {
    @GET("movie/top250")
    Observable<ResponseBody> response(@Query("start") int start,@Query("count")int count);
}
