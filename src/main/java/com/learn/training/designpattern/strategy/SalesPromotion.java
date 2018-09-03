package com.learn.training.designpattern.strategy;

public interface SalesPromotion {

    default double promote(double total){
        return total;
    }

}
