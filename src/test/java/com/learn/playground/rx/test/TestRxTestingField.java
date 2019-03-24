package com.learn.playground.rx.test;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
