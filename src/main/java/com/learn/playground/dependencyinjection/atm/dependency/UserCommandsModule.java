package com.learn.playground.dependencyinjection.atm.dependency;

import com.learn.playground.dependencyinjection.atm.command.Command;
import com.learn.playground.dependencyinjection.atm.command.DepositCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

import javax.annotation.Nonnull;

@Module
public abstract class UserCommandsModule {

    @Binds
    @IntoMap
    @StringKey("deposit")
    abstract Command depositCommand(@Nonnull DepositCommand depositCommand);
}
