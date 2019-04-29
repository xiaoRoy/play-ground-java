package com.learn.playground.rx.test.concat;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.Test;


public class LearnConcatSingleTest {

    private LearnConcat learnConcat;

    @Before
    public void setup() {
        learnConcat = new LearnConcat();
    }

    @Test
    public void test_concatTwoSingleTakeFirst() {
        Single<String> first = Single.just("abc");
        Single<String> second = Single.just("zxy");

        TestObserver<String> testObserver = learnConcat.concatTwoSingleTakeFirst(first, second).test();
        testObserver.assertValueCount(1);
        Observable.concatArrayEager(Observable.just(1), Observable.just(3));
    }

    @Test
    public void test_concatTwoSingleTakeFirst_firstIsHeavy() {
        Single<String> first = Single.create(emitter -> {
            int result = 0;
            for (int index = 0; index < 100000; index++) {
                result += index;
            }
            emitter.onSuccess(String.valueOf(result));
        });
        Single<String> second = Single.just("zxy");
        TestObserver<String> testObserver = learnConcat.concatTwoSingleTakeFirst(first, second).test();
        testObserver.assertValueCount(1);
        testObserver.assertValue(result -> !"zxy".equals(result));
    }
}
