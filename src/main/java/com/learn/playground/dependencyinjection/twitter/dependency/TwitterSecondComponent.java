package com.learn.playground.dependencyinjection.twitter.dependency;


import com.learn.playground.dependencyinjection.twitter.TwitterApplication;
import com.learn.playground.dependencyinjection.twitter.TwitterSecondApplication;
import dagger.Component;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

@Component(modules = {
        NetworkModule.class,
        TwitterModule.class
})
@Singleton
public interface TwitterSecondComponent {

    void inject(@Nonnull TwitterSecondApplication application);
}
