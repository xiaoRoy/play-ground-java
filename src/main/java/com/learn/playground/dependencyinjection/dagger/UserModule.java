package com.learn.playground.dependencyinjection.dagger;

import com.learn.playground.dependencyinjection.model.User;
import dagger.Module;
import dagger.Provides;


@Module
public class UserModule {

    @Provides
    User providesUser(){
        return new User("Jack", "Smith");
    }
}
