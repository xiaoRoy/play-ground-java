package com.learn.playground.dependencyinjection.model;

import javax.inject.Inject;

public class Computer {

    @Inject
    Keyboard keyboard;

    /*
    * In this example, we don't use module. But if
    * we can not annotated the constructor with @Inject,
    * we had to use @Module and @Provides.
    * */
    @Inject
    public Computer() {
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
