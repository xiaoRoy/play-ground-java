package com.learn.training.decorator;

public class Coffee implements Ingredient {

    @Override
    public float cost() {
        return 21f;
    }
}
