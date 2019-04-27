package com.learn.playground.rx.test.concat;


import io.reactivex.Observable;

public class LearnConcat {

    public <T> Observable<T> concatTwo(Observable<T> first, Observable<T> second) {
        return Observable.concat(first, second);
    }

    public <T> Observable<T> concatTwoTakeFirst(Observable<T> first, Observable<T> second) {
        return concatTwo(first, second).take(1);
    }
}
