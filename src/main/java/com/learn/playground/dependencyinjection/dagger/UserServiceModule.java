package com.learn.playground.dependencyinjection.dagger;

import com.learn.playground.dependencyinjection.model.User;
import dagger.Module;
import dagger.Provides;

@Module
public class UserServiceModule {

    private User user;

    public UserServiceModule(User user) {
        this.user = user;
    }

    @Provides
    public User providesUser(){
        return this.user;
    }

    @Provides
    UserService providesUserService(){
        return new UserService();
    }
}
