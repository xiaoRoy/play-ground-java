package com.learn.training.designpattern.strategy;

public class FiftyOffSalesPromotion implements SalesPromotion {

    @Override
    public double promote(double total) {
        return total * 0.5;
    }
}
