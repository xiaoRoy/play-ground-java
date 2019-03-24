package com.learn.playground.rx.test;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRxTestingField {

    @Test
    public void test_combineLetterAndNumber() {
        RxTestingField rxTestingField = new RxTestingField();
        Observable<String> resultObservable =
                rxTestingField.combineLetterAndNumber(Arrays.asList("A", "B", "C", "D", "E"));
        List<String> result = new ArrayList<>();
        resultObservable.subscribe(result::add);
        Assert.assertEquals(5, result.size());
    }

    @Test
    public void test_combineLetterAndNumber_use_testSubscriber() {
        RxTestingField rxTestingField = new RxTestingField();
        Observable<String> resultObservable =
                rxTestingField.combineLetterAndNumber(Arrays.asList("A", "B", "C", "D", "E"));

        TestObserver<String> testObserver = new TestObserver<>();
        resultObservable.subscribe(testObserver);
        testObserver.assertComplete();
        testObserver.assertNoErrors();
        testObserver.assertValueCount(5);
    }

    @Test
    public void test_combineLetterAndNumber_use_testSubscriber_onError() {
        RxTestingField rxTestingField = new RxTestingField();
        Observable<String> resultObservable =
                rxTestingField.combineLetterAndNumberWithError(Arrays.asList("A", "B", "C", "D", "E"));

        TestObserver<String> testObserver = new TestObserver<>();
        resultObservable.subscribe(testObserver);
        testObserver.assertError(IOException.class);
        testObserver.assertNotComplete();
    }

    @Test
    public void test_combineLetterAndNumber_use_testSubscriber_testScheduler() {
        TestScheduler testScheduler = new TestScheduler();
        TestObserver<String> testObserver = new TestObserver<>();
        RxTestingField rxTestingField = new RxTestingField();
        Observable<String> resultObservable =
                rxTestingField.combineLetterAndNumberHasInterval(Arrays.asList("A", "B", "C", "D", "E"), testScheduler);
        resultObservable.subscribe(testObserver);

        testObserver.assertNoValues();
        testObserver.assertNotComplete();

        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS);
        testObserver.assertNotComplete();
        testObserver.assertValueCount(1);
        testObserver.assertValues("A-0");

        testScheduler.advanceTimeBy(6, TimeUnit.SECONDS);
        testObserver.assertComplete();
        testObserver.assertValueCount(5);
    }
}
