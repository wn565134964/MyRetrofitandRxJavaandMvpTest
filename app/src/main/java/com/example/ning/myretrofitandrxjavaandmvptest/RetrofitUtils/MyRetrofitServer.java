package com.example.ning.myretrofitandrxjavaandmvptest.RetrofitUtils;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyRetrofitServer {
    @GET("/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
    Observable<Bean> getYMDX();
}
