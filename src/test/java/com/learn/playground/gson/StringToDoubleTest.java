package com.learn.playground.gson;

import org.junit.Assert;
import org.junit.Test;

public class StringToDoubleTest {
    private static final String GIFT_JSON = "{\"name\": \"apple\", \"price\":145.326}";
    private static final String GIFT_JSON_STRING_PRICE = "{\"name\": \"apple\", \"price\":\"145.326\"}";

    @Test
    public void test_parse_gift(){
        StringToDouble parser = new StringToDouble();
        Assert.assertEquals(145.326, parser.parserGift(GIFT_JSON).getPrice(), 0.0d);
    }

    @Test
    public void test_parse_gift_with_string_price(){
        StringToDouble parser = new StringToDouble();
        Assert.assertEquals(145.326, parser.parserGift(GIFT_JSON_STRING_PRICE).getPrice(), 0.0d);
    }

    @Test
    public void test_parse_gift_long_price_with_string_price(){
        StringToDouble parser = new StringToDouble();
        Assert.assertEquals(145.326, parser.parseGift(GIFT_JSON_STRING_PRICE).getPrice(), 0.0d);
    }
}
