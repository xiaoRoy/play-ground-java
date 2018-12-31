package com.learn.training.concurrent;

public class ConcurrentUseCase {


    /*
    * A thread do a operation for 10 times
    * then
    * Main thread do a operation for 5 times
    * then
    * Both of the thread switch 50 times
    * */

    private void switchBetweenThread() {
    }

    private static class Operation {

        private boolean isFirstRunning;

        private synchronized void firstOp() {

        }

        private synchronized void secondOp() {

        }
    }
}
