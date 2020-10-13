package com.learn.playground.rx.error;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

public class FlatMapError {

    @Test
    public void test_flatMap_onError() {
        Observable<Integer> numberObservable = Observable.just(1, 5).flatMap(number -> {
            Observable<Integer> result;
            if (number > 1) {
                throw new IllegalArgumentException();
            } else {
                result = Observable.just(number);
            }
            return result;
        });
        TestObserver testObserver = numberObservable.test();
        testObserver.assertValueCount(1);
        testObserver.assertError(IllegalArgumentException.class);
    }
}
