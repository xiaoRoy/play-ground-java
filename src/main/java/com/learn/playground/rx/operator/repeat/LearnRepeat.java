package com.learn.playground.rx.operator.repeat;

import io.reactivex.Observable;

import java.util.concurrent.atomic.AtomicInteger;

public class LearnRepeat {

    private void repeat() {
        Observable.just(new AtomicInteger(-100)).doOnNext(offset -> offset.getAndAdd(100))
                .repeat()
                .takeUntil(number -> number.intValue() > 300)
                .subscribe(System.out::println);
    }

    private void repeatAnother() {
        final AtomicInteger offset = new AtomicInteger(0);
        Observable.just(1, 2, 3, 4, 5, 0)
                .repeat()
                /* .takeWhile(text -> {
                     return text.length() <= 4;
                 })*/
                .takeWhile(number -> {


                    return number > 0;
                }).doOnNext(result -> {
            offset.getAndAdd(100);
            System.out.println("offset:" + offset);
        })
                .subscribe(result -> {
                    System.out.println("result:" + result);
                });
    }


    public static void main(String[] args) {
        new LearnRepeat().repeat();
    }

    /*
    *  Observable.just(new AtomicInteger(-100)).doOnNext(offset -> offset.getAndAdd(100))
                .repeat()
                .takeUntil(number -> number.intValue() > 300)
                .subscribe(System.out::println);
    * */
}
