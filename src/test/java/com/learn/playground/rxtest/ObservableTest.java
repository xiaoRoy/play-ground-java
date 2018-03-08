package com.learn.playground.rxtest;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
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
        Observable<String> loadData();
        @GET("/") Observable<Response<String>> response();
    }

    @Before
    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(server.url("/"))
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        service = retrofit.create(Service.class);
    }

    @Test
    public void bodySuccess200() {
        server.enqueue(new MockResponse().setBody("Hi"));
        TestObserver<String> testObserver = TestObserver.create();
        service.loadData().subscribe(testObserver);
        testObserver.assertValueCount(1);
        testObserver.assertValue("Hi").assertComplete();
    }
}
