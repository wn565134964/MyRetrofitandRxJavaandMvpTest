package com.example.ning.myretrofitandrxjavaandmvptest.Module;

import android.content.Context;

import com.example.ning.myretrofitandrxjavaandmvptest.RetrofitUtils.Bean;
import com.example.ning.myretrofitandrxjavaandmvptest.RetrofitUtils.MyRetrofitServer;
import com.example.ning.myretrofitandrxjavaandmvptest.RetrofitUtils.myRetrofitHelp;

import io.reactivex.Observable;

public class myModule {
    private MyRetrofitServer mServer;

    public myModule(Context context,String url) {
        this.mServer = myRetrofitHelp.getInstance(context,url).getRetrofit();
    }
    public Observable<Bean> get_ymdx(){
        return mServer.getYMDX();
    }
}
