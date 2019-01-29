package com.learn.playground.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;

public class TestGetAsJsonArray {

    private static String RESPONSE_JSON_ARRAY = "{\"didYouMean\": [{\n" +
            "\t\t\"suggestion\": \"cassis\",\n" +
            "\t\t\"frequency\": \"3\"\n" +
            "\t}]}";

    @Test
    public void test_parse_json_array(){
        JsonElement response = new JsonParser().parse(RESPONSE_JSON_ARRAY);
        //In Kotlin  response.asJsonObject["didYouMean"]
        JsonElement suggestions = response.getAsJsonObject().get("didYouMean");
        Assert.assertTrue(suggestions.isJsonArray());
    }
}
