package com.learn.playground.dependencyinjection.news.ui;

import com.learn.playground.dependencyinjection.news.presenter.NewsDetailsPresenter;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class NewsDetailFragment {

    @Inject
    @Nonnull
    NewsDetailsPresenter newsDetailsPresenter;
}
