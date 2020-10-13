package com.learn.playground.dependencyinjection.atm.dependency;

import com.learn.playground.dependencyinjection.atm.ouputter.Outputter;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class SystemOutModule {

    @Provides
    static Outputter textOutputter() {
        return System.out::println;
    }
}
