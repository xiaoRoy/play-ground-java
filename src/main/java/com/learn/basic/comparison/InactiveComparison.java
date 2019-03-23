package com.learn.basic.comparison;

public class InactiveComparison extends Comparison{

    private final int result;

    InactiveComparison(int result) {
        this.result = result;
    }

    @Override
    public Comparison compare(Comparable<?> one, Comparable<?> another) {
        return this;
    }

    @Override
    public int result() {
        return result;
    }
}
