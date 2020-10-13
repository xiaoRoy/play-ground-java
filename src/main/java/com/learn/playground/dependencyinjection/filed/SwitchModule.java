package com.learn.playground.dependencyinjection.filed;

import dagger.Module;
import dagger.Provides;

@Module
public class SwitchModule {

    @Provides
    Switch provideSwitch() {
        return new Switch();
    }
}
