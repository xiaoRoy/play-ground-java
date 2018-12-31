package com.learn.training.concurrent;

import java.util.concurrent.*;

public class CallableCase implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "from callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        FutureTask<String> futureTask = new FutureTask<>(new CallableCase());
        executorService.submit(new CallableCase()).get();
    }
}
