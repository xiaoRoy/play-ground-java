package com.learn.playground.dependencyinjection.news.di;

import com.learn.playground.dependencyinjection.news.data.BaseNewsRepository;
import com.learn.playground.dependencyinjection.news.data.CacheNewsRepository;
import dagger.Binds;
import dagger.Module;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

@Module
public abstract class NewsRepositoryModule  {


    @Binds
    @Nonnull
    abstract BaseNewsRepository bindNewsRepository(@Nonnull CacheNewsRepository cacheNewsRepository);
}
