package com.learn.playground.dependencyinjection.twitter.httpclient;

import javax.annotation.Nonnull;

public class Call {

    @Nonnull
    public Response execute() {
        return new Response();
    }
}
