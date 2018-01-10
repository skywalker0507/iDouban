package com.skywalker.idouban.models.movie;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/9               *
 *******************************/

public interface InTheaters {
    @GET("movie/in_theaters")
    Observable<ResponseBody> response();
}
