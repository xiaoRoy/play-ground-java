package com.learn.playground.dependencyinjection.filed;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class Clock {

    @Inject
    @Nonnull
    Switch aSwitch;

    @Inject
    public Clock() {
    }

    public static void main(String[] args) {
        ClockComponent clockComponent = DaggerClockComponent.create();
        Clock clock = clockComponent.buildClock();
        System.out.println(clock.aSwitch.color);
    }
}
