package com.learn.playground.dependencyinjection.atm.dependency;

import com.learn.playground.dependencyinjection.atm.command.Command;
import com.learn.playground.dependencyinjection.atm.command.LoginCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

import javax.annotation.Nonnull;

@Module
public abstract class LoginCommandModule {

    @Binds
    @IntoMap
    @StringKey("login")
    abstract Command loginCommand(@Nonnull LoginCommand loginCommand);
}
