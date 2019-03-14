package com.example.ning.myretrofitandrxjavaandmvptest.RetrofitUtils;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class myRetrofitHelp {
    private Context mContext;
    private String url;
    private OkHttpClient mClient = new OkHttpClient();
    private static myRetrofitHelp mHelper;
    private Retrofit retrofit;

    public myRetrofitHelp(Context context, String url) {
        mContext = context;
        this.url = url;
        init();
    }

    private void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(mClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public MyRetrofitServer getRetrofit() {
        return retrofit.create(MyRetrofitServer.class);
    }
    public static synchronized myRetrofitHelp getInstance(Context context,String Url){
        if(mHelper == null){
            mHelper = new myRetrofitHelp(context,Url);
        }
        return mHelper;
    }
}
