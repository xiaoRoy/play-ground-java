package com.learn.playground.dependencyinjection.news.di;

import com.learn.playground.dependencyinjection.news.data.BaseEditorRepository;
import com.learn.playground.dependencyinjection.news.data.BaseNewsRepository;
import com.learn.playground.dependencyinjection.news.presenter.AddNewsPresenter;
import com.learn.playground.dependencyinjection.news.presenter.BaseAddNewsPresenter;
import com.learn.playground.dependencyinjection.news.presenter.BaseNewsListPresenter;
import com.learn.playground.dependencyinjection.news.presenter.NewsListPresenter;
import dagger.Module;
import dagger.Provides;

import javax.annotation.Nonnull;

@Module
public class NewsModule {

 /*   @Nonnull
    private final BaseEditorRepository editorRepository;

    public NewsModule(@Nonnull BaseEditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }*/

    @Provides
    public BaseAddNewsPresenter provideAddNewsPresenter(@Nonnull BaseEditorRepository editorRepository) {
        return new AddNewsPresenter(editorRepository);
    }
}
