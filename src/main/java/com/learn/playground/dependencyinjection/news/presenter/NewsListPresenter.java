package com.learn.playground.dependencyinjection.news.presenter;

import com.learn.playground.dependencyinjection.news.data.BaseNewsRepository;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class NewsListPresenter implements BaseNewsListPresenter {

    @Nonnull
    @Inject
    BaseNewsRepository newsRepository;

    @Inject
    public NewsListPresenter() {
    }


}
