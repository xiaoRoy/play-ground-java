package com.learn.playground.dependencyinjection.atm.dependency;

import com.learn.playground.dependencyinjection.atm.CommandRouter;
import dagger.Component;

@Component(modules = {HelloWorldModule.class})
public interface CommandRouterComponent {

    CommandRouter router();
}
