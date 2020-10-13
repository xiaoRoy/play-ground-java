package com.learn.playground.rx.test.concat;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class LearnAmbTest {

    private LearnAmb learnAmb;

    @Before
    public void setup() {
        learnAmb = new LearnAmb();
    }

    @Test
    public void test_ambTwo() {
        Observable<Integer> first = Observable.just(44);
        Observable<Integer> second = Observable.just(21);
        TestObserver<Integer> testObserver = learnAmb.ambTwo(first, second).test();
        testObserver.assertValue(44);
    }

    @Test
    public void test_ambTwo_firstIsHeavy() {
        Observable<String> first = Observable.create(emitter -> {
            int result = 0;
            for (int index = 0; index < 1000; index++) {
                result += index;
            }
            emitter.onNext(String.valueOf(result));
        });
        Observable<String> second = Observable.just("xyz");
        TestObserver<String> testObserver = learnAmb.ambTwo(first, second).test();
        testObserver.assertValue("499500");
    }

    @Test
    public void test_ambTwo_firstIsDelay() {
        Observable<Integer> first = Observable.just(44).delay(1, TimeUnit.MILLISECONDS);
        Observable<Integer> second = Observable.just(21);
        TestObserver<Integer> testObserver = learnAmb.ambTwo(first, second).test();
        testObserver.assertValue(21);
    }

    @Test
    public void test_ambTwo_firstError() {
        Observable<Integer> first = Observable.error(new IOException());
        Observable<Integer> second = Observable.just(21);
        TestObserver<Integer> testObserver = learnAmb.ambTwo(first, second).test();
        testObserver.assertError(IOException.class);
    }

    @Test
    public void test_ambTwo_secondError() {
        Observable<Integer> first = Observable.just(21);
        Observable<Integer> second = Observable.error(new IOException());
        TestObserver<Integer> testObserver = learnAmb.ambTwo(first, second).test();
        testObserver.assertValue(21);
    }


    @Test
    public void test_ambTwo_bothAreDelay() {
        Observable<Integer> first = Observable.just(44).delay(100, TimeUnit.MILLISECONDS);
        Observable<Integer> second = Observable.just(21).delay(99, TimeUnit.MILLISECONDS);
        TestObserver<Integer> testObserver = learnAmb.ambTwo(first, second).test();
        testObserver.awaitCount(1);
        testObserver.assertValue(21);
    }

    @Test
    public void test_ambTwo_bothAreDelay_useTestScheduler() {
        TestScheduler testScheduler = new TestScheduler();
        Observable<Integer> first = Observable.just(44).delay(100, TimeUnit.MILLISECONDS, testScheduler);
        Observable<Integer> second = Observable.just(21).delay(99, TimeUnit.MILLISECONDS, testScheduler);
        TestObserver<Integer> testObserver = learnAmb.ambTwo(first, second).test();
        testScheduler.advanceTimeBy(100, TimeUnit.MILLISECONDS);
        testObserver.assertValue(21);
    }

}
