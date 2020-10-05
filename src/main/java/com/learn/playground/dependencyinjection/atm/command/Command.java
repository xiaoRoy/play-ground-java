package com.learn.playground.dependencyinjection.atm.command;

import javax.annotation.Nonnull;
import java.util.List;

public interface Command {

    @Nonnull
    String key();

    @Nonnull
    Status handleInput(@Nonnull List<String> inputs);

    enum Status{
        INVALID, HANDLED
    }
}
