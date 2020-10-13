package com.learn.playground.dependencyinjection.filed;

import dagger.Component;

//@Component
@Component(modules = {SwitchModule.class})
public interface ClockComponent {

    Clock buildClock();
}
