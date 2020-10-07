package com.learn.playground.dependencyinjection.twitter.httpclient;

import javax.annotation.Nonnull;

public class HttpClient {

    @Nonnull
    public Call newCall(@Nonnull Reqeust reqeust) {
        return new Call();
    }

}
