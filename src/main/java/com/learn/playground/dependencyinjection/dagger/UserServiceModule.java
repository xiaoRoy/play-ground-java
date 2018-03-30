package com.learn.playground.dependencyinjection.dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class UserServiceModule {

    @Provides
    UserService provideUserService(){
        return new UserService();
    }
}
