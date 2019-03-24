package com.learn.playground.rx.test;

import io.reactivex.Observable;

import java.util.List;

public class RxTestingField {

    public RxTestingField() {
    }

    public Observable<String> combineLetterAndNumber(List<String> letters) {
        return Observable.fromIterable(letters)
                .zipWith(Observable.range(1, 100), (letter, number) -> letter + "-" + number);
    }
}
