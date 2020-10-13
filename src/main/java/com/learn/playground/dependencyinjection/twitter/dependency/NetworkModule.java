package com.learn.playground.dependencyinjection.twitter.dependency;

import com.learn.playground.dependencyinjection.twitter.TwitterApi;
import com.learn.playground.dependencyinjection.twitter.httpclient.HttpClient;
import dagger.Module;
import dagger.Provides;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

@Module
public class NetworkModule {


    @Nonnull
    @Provides
    @Singleton
    HttpClient provideHttpClient() {
        return new HttpClient();
    }

    @Nonnull
//    @Provides
    TwitterApi provideTwitterApi(@Nonnull HttpClient httpClient) {
        return new TwitterApi(httpClient);
    }
}
