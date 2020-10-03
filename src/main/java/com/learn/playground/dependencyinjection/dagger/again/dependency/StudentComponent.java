package com.learn.playground.dependencyinjection.dagger.again.dependency;

import com.learn.playground.dependencyinjection.dagger.again.StudentApp;
import dagger.Component;

import javax.annotation.Nonnull;

@Component(modules = {StudentModule.class})
public interface StudentComponent {

    /*
     *If you want to use filed injection you have to define
     * a method in your Component interface which takes the instance
     * into which you want to inject as parameter.
     * */
    void inject(@Nonnull StudentApp app);
}
