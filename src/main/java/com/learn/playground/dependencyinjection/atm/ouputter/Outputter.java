package com.learn.playground.dependencyinjection.atm.ouputter;

import javax.annotation.Nonnull;

public interface Outputter {

    void output(@Nonnull String output);
}
