package com.learn.training.designpattern.decorator;

public class Sugar extends CoffeeIngredient {

    public Sugar(Ingredient ingredient) {
        super(ingredient);
    }

    @Override
    public float cost() {
        return super.cost() + 3f;
    }
}
