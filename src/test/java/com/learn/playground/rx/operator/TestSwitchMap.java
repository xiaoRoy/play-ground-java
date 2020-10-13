package com.learn.playground.rx.operator;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestSwitchMap {

    private Observable<Integer> numbers = Observable.fromArray(1, 2, 4, 44);

    @Test
    public void test_switchMap() {

        TestScheduler testScheduler = new TestScheduler();
        TestObserver<String> testObserver =
        numbers.switchMap(number ->
                Observable
                        .just(number.toString()).delay(1, TimeUnit.SECONDS, testScheduler)
                )
                .subscribeOn(testScheduler)
                .test();
        testScheduler.advanceTimeBy(4, TimeUnit.SECONDS);
        testObserver.assertValueCount(1);
    }
}
