package com.learn.training.decorator;

public abstract class CoffeeIngredient implements Ingredient {

    private final Ingredient ingredient;

    public CoffeeIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public float cost() {
        return ingredient.cost();
    }
}
