package com.learn.playground.dependencyinjection.news.ui;

import com.learn.playground.dependencyinjection.news.presenter.BaseAddNewsPresenter;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class AddNewsFragment {

    @Inject
    @Nonnull
    BaseAddNewsPresenter addNewsPresenter;


}
