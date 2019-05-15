package com.learn.playground.rx.test.concat;

import io.reactivex.Observable;

import java.util.Arrays;

public class LearnAmb {


    public <T> Observable<T> ambTwo(Observable<T> first, Observable<T> second) {
        return Observable.amb(Arrays.asList(first, second));
    }
}
