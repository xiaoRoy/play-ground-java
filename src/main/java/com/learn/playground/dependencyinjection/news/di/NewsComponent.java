package com.learn.playground.dependencyinjection.news.di;

import com.learn.playground.dependencyinjection.news.ui.NewsDetailFragment;
import com.learn.playground.dependencyinjection.news.ui.NewsListFragment;
import dagger.Component;

import javax.annotation.Nonnull;
import javax.inject.Singleton;


@Component(modules = {NewsRepositoryModule.class})
@Singleton
public interface NewsComponent {

    void injectNewsList(@Nonnull NewsListFragment newsListFragment);

    void injectNewsDetail(@Nonnull NewsDetailFragment newsDetailFragment);
}
