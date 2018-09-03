package com.learn.training.designpattern.strategy;

public class ASalesPromotion implements SalesPromotion {

    @Override
    public double promote(double total) {
        double result = total;
        if(total > 100.0){
            result -= 10.0d;
        }
        return result;
    }
}
