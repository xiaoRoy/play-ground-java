package com.learn.playground.dependencyinjection.twitter.dependency;

import com.learn.playground.dependencyinjection.twitter.TwitterApplication;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {
        NetworkModule.class,
        TwitterModule.class
})
@Singleton
public interface TwitterComponent {

    TwitterApplication application();
}
