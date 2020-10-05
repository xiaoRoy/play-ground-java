package com.learn.playground.dependencyinjection.atm.dependency;

import com.learn.playground.dependencyinjection.atm.CommandRouter;
import dagger.Component;

import javax.annotation.Nonnull;

@Component(modules = {LoginCommandModule.class, SystemOutModule.class})
public interface CommandRouterComponent {

    @Nonnull
    CommandRouter router();
}
