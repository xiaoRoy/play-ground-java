package com.learn.playground.rx.schduler.timer;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class TimerScheduler {

    private void xX(){
        Observable
                .timer(500, TimeUnit.MILLISECONDS, Schedulers.trampoline())
                .doOnEach(new Consumer<Notification<Long>>() {
                    @Override
                    public void accept(Notification<Long> notification) throws Exception {
                        logThreadName();
                    }
                })
                .subscribe(aLong -> logThreadName());
    }


    private static void logThreadName(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
    }

    public static void main(String[] args) {
        new TimerScheduler().xX();
        System.out.println("Not block");
        while (true){}
    }
}
