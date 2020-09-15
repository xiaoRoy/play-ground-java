package com.learn.basic.constructor;

public class Dog extends Animal {

    private final String name;

    public Dog(String name) {
//        super(); implicit call super();
        this.name = name;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Luck");
    }
}
