package com.learn.playground.dependencyinjection.news.presenter;

import com.learn.playground.dependencyinjection.news.data.BaseNewsRepository;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class NewsDetailsPresenter implements BaseNewsDetailPresenter {

    @Nonnull
    private final BaseNewsRepository newsRepository;

    @Inject
    public NewsDetailsPresenter(BaseNewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
}
