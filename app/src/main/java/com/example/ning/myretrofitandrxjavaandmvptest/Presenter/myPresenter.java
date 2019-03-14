package com.example.ning.myretrofitandrxjavaandmvptest.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.ning.myretrofitandrxjavaandmvptest.RetrofitUtils.Bean;
import com.example.ning.myretrofitandrxjavaandmvptest.Module.myModule;
import com.example.ning.myretrofitandrxjavaandmvptest.View.myView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class myPresenter implements YMDXPresenter{
    private Context mContext;
    private String url;
    private Bean mBean;
    private myModule mModule;
    private myView mView;
    public myPresenter(Context context, String url) {
        mContext = context;
        this.url = url;
    }

    @Override
    public void getYMDX_Info() {
        mModule.get_ymdx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        myPresenter.this.mBean = bean;
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("信息","错误");
                    }

                    @Override
                    public void onComplete() {
                        if (mBean != null){
                            mView.success(mBean);
                        }
                    }
                });
    }

    @Override
    public void create() {
        mModule = new myModule(mContext,url);
    }

    @Override
    public void stop() {
    }

    @Override
    public void attachView(com.example.ning.myretrofitandrxjavaandmvptest.View.View view) {
        mView = (myView)view;
    }

}
