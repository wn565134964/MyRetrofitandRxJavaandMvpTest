package com.example.ning.myretrofitandrxjavaandmvptest.Presenter;


import com.example.ning.myretrofitandrxjavaandmvptest.View.View;

public interface Presenter {
    void create();
    void stop();
    void attachView(View view);
}
