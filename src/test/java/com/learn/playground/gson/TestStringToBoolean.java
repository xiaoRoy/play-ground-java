package com.learn.playground.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

public class TestStringToBoolean {

    private static String JSON_STRING_BOOLEAN = "{\"cash_fund\":\"TRUE\"}";


    @Test
    public void test_parse_string_to_boolean(){
        JsonObject jsonObject = new JsonParser().parse(JSON_STRING_BOOLEAN).getAsJsonObject();
        boolean result = jsonObject.getAsJsonPrimitive("cash_fund").getAsBoolean();
        Assert.assertTrue(result);
    }
}
