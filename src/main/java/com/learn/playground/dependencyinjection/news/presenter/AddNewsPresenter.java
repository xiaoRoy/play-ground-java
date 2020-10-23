package com.learn.playground.dependencyinjection.news.presenter;

import com.learn.playground.dependencyinjection.news.data.BaseEditorRepository;
import com.learn.playground.dependencyinjection.news.data.BaseNewsRepository;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class AddNewsPresenter implements BaseAddNewsPresenter {

    @Nonnull
    private final BaseEditorRepository editorRepository;

    @Inject
    public AddNewsPresenter(@Nonnull BaseEditorRepository editorRepository) {
        this.editorRepository = editorRepository;
    }
}
