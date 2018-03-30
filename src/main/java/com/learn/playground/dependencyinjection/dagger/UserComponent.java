package com.learn.playground.dependencyinjection.dagger;


import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {UserModule.class, UserServiceModule.class})
public interface UserComponent {

    UserService provideUserService();

    void inject(UserApplication userApplication);
}
