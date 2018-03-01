package com.learn.playground.rxtest;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

import java.io.IOException;

public class ObservableTest {

    @Rule public final MockWebServer server = new MockWebServer();

    private Service service;

    interface Service {
        @GET("/")
        Observable<String> body();
        @GET("/") Observable<Response<String>> response();
    }

    @Before
    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .build();
        service = retrofit.create(Service.class);
    }

    private OkHttpClient getOkHttpClient(){
        return new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request.Builder requsetBuilder = chain.request().newBuilder();
                Request request = chain.request();
                System.out.println("trail.host:" + request.url().host());
                System.out.println("trail.port:" + request.url().port());
                System.out.println("trail.path:" + request.url().encodedPath());
                System.out.println("trail.url:" + request.url().toString());
                return chain.proceed(requsetBuilder.build());
            }
        }).build();
    }

    @Test
    public void bodySuccess200() {
        server.enqueue(new MockResponse().setBody("Hi"));
        TestObserver<String> testObserver = TestObserver.create();
        service.body().subscribe(testObserver);
        testObserver.assertValueCount(1);
        testObserver.assertValue("Hi").assertComplete();
    }
}
