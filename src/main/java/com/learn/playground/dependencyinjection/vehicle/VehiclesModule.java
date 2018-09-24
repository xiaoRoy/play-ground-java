package com.learn.playground.dependencyinjection.vehicle;

import com.learn.playground.dependencyinjection.model.Brand;
import com.learn.playground.dependencyinjection.model.Engine;
import com.learn.playground.dependencyinjection.model.User;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class VehiclesModule {

    @Provides
    public Engine provideEngine(){
        return new Engine();
    }

    @Provides
    @Singleton
    public Brand provideBrand(){
        return new Brand("Top");
    }

    @Provides
    public User provideUser(){
        return new User("Mary", "Jane");
    }
}
