package com.learn.training.concurrent;

public class WaitAndNotify {


    private void expectXxException() throws InterruptedException {
        new WaitAndNotify().wait();
    }
}
