package com.learn.playground.dependencyinjection.dagger;

import com.learn.playground.dependencyinjection.model.User;

import javax.inject.Inject;

public class UserApplication {

    @Inject public UserService userService;

    @Inject public User user;

    private UserComponent userComponent;

    public UserApplication() {
        this.userComponent = DaggerUserComponent.builder()
                .userServiceModule(new UserServiceModule())
                .userModule(new UserModule())
                .build();
        this.userComponent.inject(this);
    }

    public void showUser(){
        userService.showUser(user);
    }

    public static void main(String[] args) {
        UserApplication app = new UserApplication();
        app.showUser();
    }
}
