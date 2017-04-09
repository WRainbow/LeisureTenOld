package com.srainbow.leisureten.NetRequest;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by SRainbow on 2016/9/29.
 */
public class RetrofitThing {
    public static RequestApi requestApi;

    public RequestApi getRequestApi(){
        if(requestApi==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl("http://v.juhe.cn/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            requestApi=retrofit.create(RequestApi.class);
        }
        return requestApi;
    }

    public void onFunnyPicResponse(SubscriberByTag subscriber){
        getRequestApi().getFunnyPicData("b3c10341bc734b752fa7cb47b1fb0641")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void onJokeResponse(SubscriberByTag subscriber){
        getRequestApi().getJokeData("b3c10341bc734b752fa7cb47b1fb0641")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final RetrofitThing INSTANCE = new RetrofitThing();
    }

    //获取单例
    public static RetrofitThing getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
