package com.learn.training.designpattern.strategy;

public class Shop {

    private SalesPromotion salesPromotion;

    public void setSalesPromotion(SalesPromotion salesPromotion) {
        this.salesPromotion = salesPromotion;
    }

    public double calculateTotal(double total){
        double result = total;
        if(salesPromotion != null){
            result = salesPromotion.promote(total);
        }
        return result;
    }
}
