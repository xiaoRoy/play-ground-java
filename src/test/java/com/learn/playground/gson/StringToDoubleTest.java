package com.learn.playground.gson;

import com.google.gson.JsonSyntaxException;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

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

    @Test(expected = JsonSyntaxException.class)
    public void test_parse_gift_long_price_with_string_price(){
        StringToDouble parser = new StringToDouble();
        parser.parseGift(GIFT_JSON_STRING_PRICE).getPrice();
    }

    @Test
    public void test_parse_gift_long_price_with_string_price_exception(){
        StringToDouble parser = new StringToDouble();
        try{
            parser.parseGift(GIFT_JSON_STRING_PRICE).getPrice();
            fail("Expect a JsonSyntaxException");
        } catch (JsonSyntaxException exception){
            assertThat(exception.getMessage(), is("java.lang.NumberFormatException: Expected a long but was 145.326 at line 1 column 36 path $.price"));
        }
    }
}
