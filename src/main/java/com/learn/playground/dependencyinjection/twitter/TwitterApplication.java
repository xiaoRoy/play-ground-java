package com.learn.playground.dependencyinjection.twitter;

import com.learn.playground.dependencyinjection.twitter.httpclient.HttpClient;

public class TwitterApplication {

    public static void main(String[] args) {
        HttpClient httpClient = new HttpClient();
        TwitterApi twitterApi = new TwitterApi(httpClient);
        String user = "Not Me";

        Tweeter tweeter = new Tweeter(twitterApi, user);
        tweeter.tweet("Hello Dagger2");
        TimeLine timeLine = new TimeLine(twitterApi, user);
        for(Tweet tweet :timeLine.get()) {
            System.out.println(tweet);
        }

    }
}
