package com.learn.playground.dependencyinjection.twitter;

import com.learn.playground.dependencyinjection.twitter.dependency.DaggerTwitterSecondComponent;
import com.learn.playground.dependencyinjection.twitter.dependency.TwitterModule;
import com.learn.playground.dependencyinjection.twitter.dependency.TwitterSecondComponent;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class TwitterSecondApplication implements Runnable {


    @Nonnull
    @Inject
    Tweeter tweeter;

    @Nonnull
    @Inject
    TimeLine timeLine;

    @Override
    public void run() {
        tweeter.tweet("Hello Dagger2");
        for (Tweet tweet : timeLine.get()) {
            System.out.println(tweet);
        }
    }

    public static void main(String[] args) {
        TwitterSecondApplication twitterSecondApplication = new TwitterSecondApplication();
        TwitterSecondComponent component = DaggerTwitterSecondComponent
                .builder().twitterModule(new TwitterModule("Not Me")).build();
        component.inject(twitterSecondApplication);
    }
}
