package com.learn.playground.dependencyinjection.dagger;

import javax.inject.Inject;

public class UserApplication {

    @Inject
    public UserService userService;

    private UserComponent userComponent;

    public UserApplication() {
        this.userComponent = DaggerUserComponent.builder().build();
        this.userComponent.inject(this);
    }

    public void showUser(){
        userService.showUser();
    }

    public static void main(String[] args) {
        UserApplication app = new UserApplication();
        app.showUser();
    }
}
