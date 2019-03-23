package com.learn.playground.rx.basic;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import java.io.IOException;

public class RxEvents {

    public Observable<Result> loadData() {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(Result.loadResultById(44));
                emitter.onComplete();
            } catch (IOException exception) {
                emitter.onError(exception);
            }
        });
    }


    private static class Result{
        private static Result loadResultById(int id) throws IOException {
            return new Result();
        }
    }
}
