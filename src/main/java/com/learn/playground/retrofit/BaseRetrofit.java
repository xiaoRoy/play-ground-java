package com.learn.playground.retrofit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class BaseRetrofit {

    private static volatile BaseRetrofit sBaseRetrofit = null;

    private Retrofit retrofit;

    private final OkHttpClient okHttpClient = new OkHttpClient();

    private BaseRetrofit(){
        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.client(okHttpClient)
                .baseUrl("/").build();
    }

    public static BaseRetrofit getInstance(){
        if(sBaseRetrofit == null){
            synchronized (BaseRetrofit.class){
                if(sBaseRetrofit == null){
                    sBaseRetrofit = new BaseRetrofit();
                }
            }
        }
        return sBaseRetrofit;
    }

  /*  private void init(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl()
                .addConverterFactory(ScalarsConverterFactory.create ())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    }*/

  public void load(HttpUrl httpUrl){
      Retrofit.Builder builder = retrofit.newBuilder();
  }

  public void load(String url){

  }


}
