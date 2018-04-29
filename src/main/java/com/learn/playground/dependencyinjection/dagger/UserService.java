package com.learn.playground.dependencyinjection.dagger;

import com.learn.playground.dependencyinjection.model.User;

import javax.inject.Inject;

public class UserService {

    @Inject
    public UserService() {
    }

    public void showUser(User user){
        System.out.println("User:" + user);
    }
}
