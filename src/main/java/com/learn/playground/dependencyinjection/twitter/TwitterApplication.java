package com.learn.playground.dependencyinjection.twitter;

import com.learn.playground.dependencyinjection.twitter.dependency.DaggerTwitterComponent;
import com.learn.playground.dependencyinjection.twitter.dependency.NetworkModule;
import com.learn.playground.dependencyinjection.twitter.dependency.TwitterComponent;
import com.learn.playground.dependencyinjection.twitter.dependency.TwitterModule;
import com.learn.playground.dependencyinjection.twitter.httpclient.HttpClient;
import com.learn.playground.dependencyinjection.twitter.httpclient.Streaming;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class TwitterApplication implements Runnable {


    @Nonnull
    private final Tweeter tweeter;

    @Nonnull
    private final TimeLine timeLine;

    @Inject
    public TwitterApplication(@Nonnull Tweeter tweeter, @Nonnull TimeLine timeLine) {
        this.tweeter = tweeter;
        this.timeLine = timeLine;
    }

//    @Inject
    public void enableStreaming(@Nonnull Streaming streaming) {
        streaming.register(this);
    }


    @Override
    public void run() {
        tweeter.tweet("Hello Dagger2");
        for(Tweet tweet :timeLine.get()) {
            System.out.println(tweet);
        }
    }

    public static void main(String[] args) {
    /*    HttpClient httpClient = new HttpClient();
        TwitterApi twitterApi = new TwitterApi(httpClient);
        String user = "Not Me";

        Tweeter tweeter = new Tweeter(twitterApi, user);
        tweeter.tweet("Hello Dagger2");
        TimeLine timeLine = new TimeLine(twitterApi, user);
        for(Tweet tweet :timeLine.get()) {
            System.out.println(tweet);
        }*/
        TwitterComponent component = DaggerTwitterComponent.builder()
                .twitterModule(new TwitterModule("Not Me")).build();
        component.application().run();

    }
}
