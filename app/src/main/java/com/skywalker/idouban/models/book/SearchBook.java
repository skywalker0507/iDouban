package com.skywalker.idouban.models.book;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/9               *
 *******************************/

public interface SearchBook {
    @GET("book/search")
    Observable<Response> response(@Query("q") String keywords, @Query("tag") String tag, @Query("count") int count);
}
