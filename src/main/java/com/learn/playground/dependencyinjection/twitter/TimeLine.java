package com.learn.playground.dependencyinjection.twitter;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class TimeLine {

    @Nonnull
    private final List<Tweet> tweetCache = new ArrayList<>();

    @Nonnull
    private final TwitterApi twitterApi;

    @Nonnull
    private final String user;

    public TimeLine(@Nonnull TwitterApi twitterApi, @Nonnull String user) {
        this.twitterApi = twitterApi;
        this.user = user;
    }

    @Nonnull
    public List<Tweet> get() {
        return new ArrayList<>();
    }


    public void loadMore() {

    }
}
