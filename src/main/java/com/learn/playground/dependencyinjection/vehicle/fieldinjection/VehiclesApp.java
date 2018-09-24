package com.learn.playground.dependencyinjection.vehicle.fieldinjection;

import com.learn.playground.dependencyinjection.model.User;

import javax.inject.Inject;

public class VehiclesApp {

    @Inject
    User user;

    @Inject
    public VehiclesApp() {
    }

    public User getUser() {
        return user;
    }
}
