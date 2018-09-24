package com.learn.playground.dependencyinjection.model;

import javax.inject.Inject;

public class Computer {

    @Inject
    Keyboard keyboard;

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
