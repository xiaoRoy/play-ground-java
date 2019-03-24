package com.learn.playground.rx.test;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RxTestingField {

    public RxTestingField() {
    }

    public Observable<String> combineLetterAndNumber(List<String> letters) {
        return Observable.fromIterable(letters)
                .zipWith(Observable.range(1, 100), (letter, number) -> letter + "-" + number);
    }

    public Observable<String> combineLetterAndNumberWithError(List<String> letters) {
        return combineLetterAndNumber(letters)
                .concatWith(Observable.error(new IOException()));
    }

    public Observable<String> combineLetterAndNumberHasInterval(List<String> letters, Scheduler scheduler) {
        Observable<Long> tick = Observable.interval(1, TimeUnit.SECONDS, scheduler);
        return Observable.fromIterable(letters)
                .zipWith(tick, (letter, number) -> letter + "-" + number);
    }
}
