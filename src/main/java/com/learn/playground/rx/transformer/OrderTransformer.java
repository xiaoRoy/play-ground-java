package com.learn.playground.rx.transformer;

import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

public class OrderTransformer implements ObservableTransformer<String, Order> {
    @Override
    public ObservableSource<Order> apply(Observable<String> upstream) {
        return upstream.map(response -> new Gson().fromJson(Order.JSON_EXAMPLE, Order.class));
    }
}
