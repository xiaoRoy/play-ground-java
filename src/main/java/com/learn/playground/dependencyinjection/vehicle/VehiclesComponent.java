package com.learn.playground.dependencyinjection.vehicle;

import com.learn.playground.dependencyinjection.model.Car;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = VehiclesModule.class)
@Singleton
public interface VehiclesComponent {
    Car buildCar();
}
