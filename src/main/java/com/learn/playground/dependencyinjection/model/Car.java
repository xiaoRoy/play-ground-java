package com.learn.playground.dependencyinjection.model;

import javax.inject.Inject;

public class Car {

    final private Brand brand;
    final private Engine engine;

    @Inject
    public Car(Brand brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }

    public Brand getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }
}
