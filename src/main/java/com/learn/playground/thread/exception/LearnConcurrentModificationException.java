package com.learn.playground.thread.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class LearnConcurrentModificationException {

    private static List<Integer> allNumbers = new ArrayList<>();

    static {
        for (int index = 0; index < 10000; index++) {
            allNumbers.add(index);
        }
    }

    private void iteratorNumbers(List<Integer> allNumbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> all = new ArrayList<>(allNumbers);
        for (Integer number : all) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        System.out.println("Size:" + evenNumbers.size());
    }

    public static void main(String[] args) {
        LearnConcurrentModificationException what = new LearnConcurrentModificationException();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            what.iteratorNumbers(allNumbers);
        });
        executorService.execute(() -> {
            for (int index = 0; index < 100; index++) {
                        allNumbers.add(132);
                    }
                }
        );
        executorService.shutdown();

    }

}
