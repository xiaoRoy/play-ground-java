package com.learn.playground.dependencyinjection.atm.dependency;

import com.learn.playground.dependencyinjection.atm.command.Command;
import com.learn.playground.dependencyinjection.atm.command.HelloWorldCommand;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class HelloWorldModule {

    @Binds
    abstract Command helloWorldCommand(HelloWorldCommand command);

}
