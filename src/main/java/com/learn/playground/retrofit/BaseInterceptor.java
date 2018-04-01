package com.learn.playground.retrofit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.http.Url;

import java.io.IOException;
import java.net.URL;

public abstract class BaseInterceptor implements Interceptor {

    private final HttpUrl baseUrl;

    public BaseInterceptor(HttpUrl baseUrl) {
        this.baseUrl = baseUrl;
    }

    public BaseInterceptor(String baseUrl){
        this(HttpUrl.parse(baseUrl));
    }

    public BaseInterceptor(URL baseUrl){
        this(HttpUrl.get(baseUrl));
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.url(baseUrl);
        return chain.proceed(builder.build());
    }

    protected void addHeader(Request.Builder requestBuilder){

    }
}
