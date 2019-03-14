package com.example.ning.myretrofitandrxjavaandmvptest.View;

import com.example.ning.myretrofitandrxjavaandmvptest.RetrofitUtils.Bean;

public interface myView extends View{
    void success(Bean bean);
    void onError(String s);
}
