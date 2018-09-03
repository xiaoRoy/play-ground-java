package com.learn.playground.training.designpattern.strategy;

import com.learn.training.designpattern.strategy.ASalesPromotion;
import com.learn.training.designpattern.strategy.FiftyOffSalesPromotion;
import com.learn.training.designpattern.strategy.Shop;
import org.junit.Assert;
import org.junit.Test;

public class ShopTest {

    @Test
    public void test_fifty_off_sales_promotion(){
        Shop shop = new Shop();
        shop.setSalesPromotion(new FiftyOffSalesPromotion());
        Assert.assertEquals(60.0, shop.calculateTotal(120.0), 0.0);
    }

    @Test
    public void test_a_sales_promotion_case_a(){
        Shop shop = new Shop();
        shop.setSalesPromotion(new ASalesPromotion());
        Assert.assertEquals(60.0, shop.calculateTotal(60.0), 0.0);
    }

    @Test
    public void test_a_sales_promotion_case_b(){
        Shop shop = new Shop();
        shop.setSalesPromotion(new ASalesPromotion());
        Assert.assertEquals(150.0, shop.calculateTotal(160.0), 0.0);
    }
}
