package com.learn.training.designpattern.decorator;

public class CoffeeMachine {

    public static void main(String[] args) {
        Ingredient coffee = new Milk(new Sugar(new Coffee()));
        //todo unit test
        System.out.println(coffee.cost());
    }
}
