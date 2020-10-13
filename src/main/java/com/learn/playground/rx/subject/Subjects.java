package com.learn.playground.rx.subject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

public class Subjects {

    private final PublishSubject<String> stringPublishSubject = PublishSubject.create();

    private final PublishSubject<Boolean> resultPublishSubject = PublishSubject.create();

    private final PublishSubject<Long> longPublishSubject = PublishSubject.create();

    public void firstExample() {
        stringPublishSubject.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(String result) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
        stringPublishSubject.onNext("first");
    }

    public void secondExample() {
        resultPublishSubject.subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Boolean aBoolean) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        Observable.just(1, 2, 3, 4, 5)
                .doOnComplete(stringPublishSubject::onComplete)
                .subscribe();
    }

    private void thirdExample() {
        Observable<Long> longObservable = Observable.just(1L, 23L);
        longPublishSubject.subscribe(System.out::println);
        longObservable.subscribe(longPublishSubject);
    }
}
