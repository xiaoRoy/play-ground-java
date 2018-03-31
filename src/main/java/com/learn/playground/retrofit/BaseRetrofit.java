package com.learn.playground.retrofit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.internal.cache.CacheInterceptor;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

public class BaseRetrofit {

    private static volatile BaseRetrofit sBaseRetrofit = null;

    private Retrofit retrofit;

    private static OkHttpClient sBaseOkHttpClient;

    static {
        sBaseOkHttpClient = new OkHttpClient
                .Builder()
                .connectTimeout(3000, TimeUnit.MILLISECONDS)
                .build();
    }


    protected void init(){

    }

    private BaseRetrofit(){
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
  }

  public void load(String url){

  }




}
