package com.learn.training.designpattern.decorator;

public class Milk extends CoffeeIngredient {

    public Milk(Ingredient ingredient) {
        super(ingredient);
    }

    @Override
    public float cost() {
        return super.cost() + 7f;
    }
}
