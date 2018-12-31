package com.learn.training.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LockCase {


    private static class FirstLock {

        private boolean isLocked;

        private synchronized void lock() {
            while (isLocked) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked = true;
        }

        private synchronized void unLock() {
            isLocked = false;
            notify();
        }
    }

    private static class FirstReenterLock {
        private boolean isLocked;
        private Thread lockedBy;

        private synchronized void lock() {
            while (isLocked) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked = true;
        }

        private synchronized void unLock() {
            isLocked = false;
            notify();
        }
    }


    private static class FirstLockCase {
        private FirstLock firstLock = new FirstLock();

        public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            FirstLockCase firstLockCase = new FirstLockCase();
            executorService.execute(firstLockCase::opFirstAndSecond);
//            executorService.execute(firstLockCase::opSecond);
            executorService.shutdown();
        }

        private void opFirst() {
            firstLock.lock();
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("op first");
            firstLock.unLock();
        }

        private void opSecond() {
            firstLock.lock();
            System.out.println("op second");
            firstLock.unLock();
        }

        private void opFirstAndSecond() {
            opFirst();
            opSecond();
        }
    }


}
