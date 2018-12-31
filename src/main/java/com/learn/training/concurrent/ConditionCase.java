package com.learn.training.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionCase {


    private static class Basket {
        private static final int MAX_CAPACITY = 10;

        final private Lock lock;
        private Condition conditionConsumer;
        private Condition conditionProducer;

        private List<String> items = new ArrayList<>(MAX_CAPACITY);

        public Basket(Lock lock) {
            this.lock = lock;
            conditionConsumer = lock.newCondition();
            conditionProducer = lock.newCondition();
        }

        private void put(String item) {
            lock.lock();
            try {
                while (items.size() == MAX_CAPACITY) {
                    conditionProducer.await();
                }
                items.add(item);
                conditionConsumer.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private String get() {
            lock.lock();
            String result;
            try {
                while (items.isEmpty()) {
                    conditionConsumer.await();
                }
                result = items.remove(0);
                conditionProducer.signal();
            } catch (InterruptedException e) {
                result = "";
            } finally {
                lock.unlock();
            }
            return result;
        }
    }
}
