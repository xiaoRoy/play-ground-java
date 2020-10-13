package com.learn.playground.dependencyinjection.twitter;

import com.learn.playground.dependencyinjection.twitter.httpclient.HttpClient;
import com.learn.playground.dependencyinjection.twitter.httpclient.Reqeust;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TwitterApi {

    @Nonnull
    private final HttpClient httpClient;

    @Inject
    public TwitterApi(@Nonnull HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void postTweet(@Nonnull String user, @Nonnull String tweet) {
        Reqeust reqeust = new Reqeust();
        httpClient.newCall(reqeust).execute();
    }
}
