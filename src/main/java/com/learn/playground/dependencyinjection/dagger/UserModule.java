package com.learn.playground.dependencyinjection.dagger;

import com.learn.playground.dependencyinjection.model.User;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

//@Module
public class UserModule {

//    @Provides
//    @Singleton
    User providesUser(){
        return new User("Jack", "Smith");
    }
}
