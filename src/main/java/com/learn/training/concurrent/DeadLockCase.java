package com.learn.training.concurrent;

public class DeadLockCase {

    private Object lockA = new Object();
    private Object lockB = new Object();


    private void doOpA() {
        synchronized (lockA) {
            System.out.println("lockA opA");
            synchronized (lockB) {
                System.out.println("lockB opA");
            }
        }

    }

    private void doOpB() {
        synchronized (lockB) {
            System.out.println("lockB opB");
            synchronized (lockA) {
                System.out.println("lockA opB");
            }
        }
    }
}
