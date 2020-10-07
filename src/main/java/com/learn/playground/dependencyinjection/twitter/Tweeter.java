package com.learn.playground.dependencyinjection.twitter;

import com.learn.playground.dependencyinjection.twitter.httpclient.HttpClient;

import javax.annotation.Nonnull;

public class Tweeter {

    @Nonnull
    private final TwitterApi twitterApi;

    @Nonnull
    private final String user;

    public Tweeter(@Nonnull TwitterApi twitterApi, @Nonnull String user) {
        this.twitterApi = twitterApi;
        this.user = user;
    }

    public void tweet(@Nonnull String tweet) {
        twitterApi.postTweet(user, tweet);
    }
}
