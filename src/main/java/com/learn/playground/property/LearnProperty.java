package com.learn.playground.property;

import java.util.*;

public class LearnProperty {

    public static void main(String[] args) {
        Properties properties = new Properties();
        Map<String, List<String>> multiValuesProperties = new HashMap<>();
        multiValuesProperties.put("selection", Arrays.asList("A", "B", "C"));
        properties.putAll(multiValuesProperties);


        String selection = properties.getProperty("selection");
        System.out.println(selection);

    }
}
