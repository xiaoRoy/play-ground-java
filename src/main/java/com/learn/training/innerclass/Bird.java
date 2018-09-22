package com.learn.training.innerclass;

public class Bird implements Flyable {

    class Inner implements Flyable{
        @Override
        public void fly() {

        }
    }

    @Override
    public void fly() {

    }
}
