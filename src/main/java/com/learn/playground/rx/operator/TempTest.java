package com.learn.playground.rx.operator;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TempTest {

    private void xX() {
        System.out.println("start");
        //equals observeOn(Schedulers.io())
        Observable.timer(4L, TimeUnit.SECONDS, Schedulers.io())
                .subscribe(ignoredLong -> {
                    System.out.println("subscribe");
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Thread Name:" + threadName);
                });
        System.out.println("end");
    }

    private static void xx(){
        Observable
                .just(3)
                .doOnNext(number -> System.out.println("onNext"))
                .delay(3, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        while (true){}
    }



    public static void main(String[] args) {
        xx();
    }
}
