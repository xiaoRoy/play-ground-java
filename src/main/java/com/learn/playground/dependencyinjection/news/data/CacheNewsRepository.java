package com.learn.playground.dependencyinjection.news.data;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CacheNewsRepository implements BaseNewsRepository {

    @Inject
    public CacheNewsRepository() {
    }
}
