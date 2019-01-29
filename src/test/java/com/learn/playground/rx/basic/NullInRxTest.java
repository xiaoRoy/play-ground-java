package com.learn.playground.rx.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import org.junit.Test;

public class NullInRxTest {


    @Test(expected = NullPointerException.class)
    public void test_just_null_item() {
        String result = null;
        Observable
                .just(result)
                .subscribe();
    }
}
