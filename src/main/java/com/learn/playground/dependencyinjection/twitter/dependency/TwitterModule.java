package com.learn.playground.dependencyinjection.twitter.dependency;

import com.learn.playground.dependencyinjection.twitter.TimeLine;
import com.learn.playground.dependencyinjection.twitter.Tweeter;
import com.learn.playground.dependencyinjection.twitter.TwitterApi;
import dagger.Module;
import dagger.Provides;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

@Module
public class TwitterModule {

    @Nonnull
    private final String user;

    public TwitterModule(@Nonnull String user) {
        this.user = user;
    }

    @Provides
    @Nonnull
    @Singleton
    Tweeter provideTweeter(@Nonnull TwitterApi twitterApi) {
        return new Tweeter(twitterApi, user);
    }

    @Provides
    @Nonnull
    @Singleton
    TimeLine provideTimeLine(@Nonnull TwitterApi twitterApi) {
        return new TimeLine(twitterApi, user);
    }
}
