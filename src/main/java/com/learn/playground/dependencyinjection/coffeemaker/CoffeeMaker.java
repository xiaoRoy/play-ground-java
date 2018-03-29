package com.learn.playground.dependencyinjection.coffeemaker;

import javax.inject.Inject;

public class CoffeeMaker {
    @Inject Heater heater;
    @Inject Pump pump;
}
