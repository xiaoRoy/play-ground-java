package com.learn.playground.dependencyinjection.news.di;

import com.learn.playground.dependencyinjection.news.data.BaseEditorRepository;
import com.learn.playground.dependencyinjection.news.ui.AddNewsFragment;
import com.learn.playground.dependencyinjection.news.ui.NewsDetailFragment;
import com.learn.playground.dependencyinjection.news.ui.NewsListFragment;
import dagger.BindsInstance;
import dagger.Component;

import javax.annotation.Nonnull;
import javax.inject.Singleton;


@Component(modules = {NewsRepositoryModule.class, NewsModule.class})
@Singleton
public interface NewsComponent {

    void injectNewsList(@Nonnull NewsListFragment newsListFragment);

    void injectNewsDetail(@Nonnull NewsDetailFragment newsDetailFragment);

    void injectAddNews(@Nonnull AddNewsFragment addNewsFragment);


    @Component.Builder
    interface Builder {

        @Nonnull
        @BindsInstance
        Builder editorRepository(BaseEditorRepository editorRepository);

        @Nonnull
        NewsComponent build();
    }
}
