package com.learn.playground.dependencyinjection.news.ui;

import com.learn.playground.dependencyinjection.news.presenter.NewsDetailsPresenter;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class NewsListFragment {

    @Inject
    @Nonnull
    NewsDetailsPresenter newsDetailsPresenter;
}
