package com.learn.playground.rx.basic;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

import java.util.concurrent.Callable;

public class NullInRx {


    private Observer<String> logObserver = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {
            System.out.println("onSubscribe");
        }

        @Override
        public void onNext(String item) {
            System.out.println("onNext");
        }

        @Override
        public void onError(Throwable e) {
            System.out.println("onError");
        }

        @Override
        public void onComplete() {
            System.out.println("onComplete");
        }
    };

    private Observable<String> getJwt() {
        return Observable.just("JWT");
    }

    private Observable<String> deleteBook(String jwt, String bookId) {
        return Observable.fromCallable(() -> doDeleteBook(bookId))
                .onErrorResumeNext((Function<Throwable, ObservableSource<String>>) exception ->
                        Observable.error(exception)
        );
    }

    private String doDeleteBook(String bookId) {
        return null;
    }

    private void xx() {
        deleteBook("jwt", "123")
                .subscribe(logObserver);
    }

    private void xxXx() {
        getJwt().flatMap(jwt -> deleteBook(jwt, "123"))
                .subscribe(logObserver);
    }


    public static void main(String[] args) {
        new NullInRx().xxXx();
    }
}
