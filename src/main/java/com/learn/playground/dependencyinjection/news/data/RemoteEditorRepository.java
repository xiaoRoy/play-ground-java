package com.learn.playground.dependencyinjection.news.data;

import javax.annotation.Nonnull;

public class RemoteEditorRepository implements BaseEditorRepository {

    private static class Holder {
        static final RemoteEditorRepository INSTANCE = new RemoteEditorRepository();
    }

    private RemoteEditorRepository() {
    }

    @Nonnull
    public static RemoteEditorRepository getInstance() {
        return Holder.INSTANCE;
    }
}
