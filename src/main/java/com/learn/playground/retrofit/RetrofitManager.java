package com.learn.playground.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

public class RetrofitManager {

    private static OkHttpClient sOkHttpClient;

    private static Retrofit.Builder sRetrofitBuilder;

    private static Retrofit sRetrofit;

    static {
        sOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS)
                .writeTimeout(3, TimeUnit.SECONDS)
                .build();

    }

    public static void init() {
        sRetrofit = new Retrofit.Builder()
                .baseUrl("/")
                .client(sOkHttpClient)
                .build();
    }



}
