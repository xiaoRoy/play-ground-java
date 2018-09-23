package com.learn.playground.dependencyinjection.model;

public class Brand {

    private final String type;

    public Brand(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
