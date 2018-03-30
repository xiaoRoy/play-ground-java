package com.learn.playground.dependencyinjection.dagger;

import dagger.Component;
import dagger.internal.DaggerCollections;

import javax.inject.Inject;
import javax.inject.Singleton;

public class UserApplication {

    @Inject
    UserService userService;

    private UserComponent userComponent;

    public UserApplication() {
    }

    public static void main(String[] args) {
    }
}
