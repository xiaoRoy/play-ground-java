package com.learn.playground.dependencyinjection.dagger;


import com.learn.playground.dependencyinjection.model.User;
import dagger.Component;

@Component(modules = {UserServiceModule.class, UserModule.class})
public interface UserComponent {

    UserService provideUserService();

    User provideUser();

    void inject(UserApplication userApplication);
}
