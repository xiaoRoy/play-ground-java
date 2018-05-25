package com.learn.playground.gson.typeadapter;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class NestedJsonTest {

    @Test
    public void test_parse_by_json_deserializer(){
        NestedJson nestedJson = new NestedJson();
        List<String> result = nestedJson.parseByJsonDeserializer();
        Assert.assertEquals(3, result.size());
    }
}
