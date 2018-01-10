package com.skywalker.idouban.models.book;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/*******************************
 * Created by liuqiang          *
 *******************************
 * data: 2018/1/9               *
 *******************************/

public interface GetBookInfoById {
    @GET("book/id/{id}")
    Observable<ResponseBody> response(@Path("id") String id);
}
