package com.learn.playground.rx.completable;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;


public class TestCompletable {
    
    @Test
    public void test_what() {
       Observable<Integer>  what = Observable.just(1, 2, 3).
                flatMapCompletable(number -> Completable.complete())
                .toObservable();
        TestObserver<Integer> observer = what.test();
        observer.assertComplete();
        observer.assertValueCount(0);
    }
}
