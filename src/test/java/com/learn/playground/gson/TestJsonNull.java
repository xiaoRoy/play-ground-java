package com.learn.playground.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

public class TestJsonNull {

    @Test
    public void test_json_null_() {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse("null");
        Assert.assertTrue(jsonElement.isJsonNull());
    }

    @Test
    public void test_json_null() {
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse("{\"book\" : null}");
        Assert.assertTrue(jsonElement.isJsonObject());

        JsonElement bookJsonElement = jsonElement.getAsJsonObject().get("book");
        Assert.assertTrue(bookJsonElement.isJsonNull());
    }

}
