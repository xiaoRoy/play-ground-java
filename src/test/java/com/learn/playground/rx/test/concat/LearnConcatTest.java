package com.learn.playground.rx.test.concat;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LearnConcatTest {

    private LearnConcat learnConcat;

    @Before
    public void setup() {
        learnConcat = new LearnConcat();
    }

    @Test
    public void test_concatTwo_both() {
        Observable<Integer> first = Observable.just(1, 2, 2);
        Observable<Integer> second = Observable.create(emitter -> {
            for (int index = 0; index < 10; index++) {
                if (index % 3 == 0) {
                    emitter.onNext(index);
                }
            }
        });
        TestObserver<Integer> testObserver =
                learnConcat.concatTwo(first, second).test();
        testObserver.assertValueCount(7);
    }

    @Test
    public void test_concatTwo_firstEmpty() {
        Observable<Integer> first = Observable.empty();
        Observable<Integer> second = Observable.just(1, 2, 2);
        TestObserver<Integer> testObserver =
                learnConcat.concatTwo(first, second).test();
        testObserver.assertValueCount(3);
    }

    @Test
    public void test_concatTwo_secondEmpty() {
        Observable<Integer> first = Observable.just(1, 2, 2, 4);
        Observable<Integer> second = Observable.empty();
        TestObserver<Integer> testObserver =
                learnConcat.concatTwo(first, second).test();
        testObserver.assertValueCount(4);
    }

    @Test
    public void test_concatTwo_firstError() {
        Observable<Integer> first = Observable.error(new IOException());
        Observable<Integer> second = Observable.just(1, 2, 2, 4);
        TestObserver<Integer> testObserver =
                learnConcat.concatTwo(first, second).test();
        testObserver.assertError(IOException.class);
    }

    @Test
    public void test_concatTwo_secondError() {
        Observable<Integer> first = Observable.just(1, 2, 2, 4);
        Observable<Integer> second = Observable.error(new IOException());
        TestObserver<Integer> testObserver =
                learnConcat.concatTwo(first, second).test();
        testObserver.assertError(IOException.class);
    }

}
