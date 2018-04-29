package com.learn.playground.dependencyinjection.dagger;


import com.learn.playground.dependencyinjection.model.User;
import dagger.Component;
import javax.inject.Singleton;

@Component(modules = {UserServiceModule.class})
public interface UserComponent {

    UserService provideUserService();

//    User providesUser();

    void inject(UserApplication userApplication);
}
