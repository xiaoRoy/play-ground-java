package com.learn.playground.dependencyinjection.twitter;

import javax.inject.Inject;

public class TwitterProcessor {

    @Inject
    Tweeter tweeter;

    @Inject
    TimeLine timeLine;
}
