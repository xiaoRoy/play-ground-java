package com.learn.playground.dependencyinjection.news.di;

import com.learn.playground.dependencyinjection.news.presenter.AddNewsPresenter;
import com.learn.playground.dependencyinjection.news.presenter.BaseAddNewsPresenter;
import dagger.Binds;

import javax.annotation.Nonnull;


public abstract class NewsModule {

    /*   @Nonnull
    private final BaseEditorRepository editorRepository;

    public NewsModule(@Nonnull BaseEditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }*/

//    @Provides
//    public BaseAddNewsPresenter provideAddNewsPresenter(@Nonnull BaseEditorRepository editorRepository) {
//        return new AddNewsPresenter(editorRepository);
//    }

    @Binds
    public abstract BaseAddNewsPresenter bindAddNewPresenter(@Nonnull AddNewsPresenter addNewsPresenter);
}
