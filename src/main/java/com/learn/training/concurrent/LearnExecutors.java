package com.learn.training.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LearnExecutors {


    private void scheduleExecutorService() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(() -> System.out.println("test"), 1, TimeUnit.SECONDS);
    }
}
