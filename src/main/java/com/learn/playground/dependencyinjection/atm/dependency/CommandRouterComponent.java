package com.learn.playground.dependencyinjection.atm.dependency;

import com.learn.playground.dependencyinjection.atm.CommandRouter;
import dagger.Component;

import javax.annotation.Nonnull;
import javax.inject.Singleton;

@Component(modules = {
        LoginCommandModule.class, SystemOutModule.class, HelloWorldModule.class,
        UserCommandsModule.class
})
@Singleton
public interface CommandRouterComponent {

    @Nonnull
    CommandRouter router();
}
