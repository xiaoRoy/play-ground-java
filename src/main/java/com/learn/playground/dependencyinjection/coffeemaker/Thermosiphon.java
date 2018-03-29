package com.learn.playground.dependencyinjection.coffeemaker;

import javax.inject.Inject;

public class Thermosiphon implements Pump{

    private final Heater heater;

    @Inject
    public Thermosiphon(Heater heater) {
        this.heater = heater;
    }

    @Override
    public void pump() {

    }
}
