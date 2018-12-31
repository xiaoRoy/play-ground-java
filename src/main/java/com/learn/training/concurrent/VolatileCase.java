package com.learn.training.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileCase {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Increment increment = new Increment();
        for(int index = 0; index < 10; index ++) {
            executorService.execute(increment::increase);
        }
    }

    private static class Increment {
        private int count;

        public void increase() {
            count ++;
        }
    }
}
