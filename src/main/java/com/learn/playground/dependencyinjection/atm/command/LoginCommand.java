package com.learn.playground.dependencyinjection.atm.command;

import com.learn.playground.dependencyinjection.atm.ouputter.Outputter;

import javax.annotation.Nonnull;
import javax.inject.Inject;

final public class LoginCommand extends SingleArgumentCommand {

    @Nonnull
    private final Outputter outputter;

    @Inject
    public LoginCommand(@Nonnull Outputter outputter) {
        this.outputter = outputter;
    }

    @Override
    protected Status handleSingeArgument(@Nonnull String arg) {
        outputter.output(arg);
        return Status.HANDLED;
    }

    @Nonnull
    @Override
    public String key() {
        return "login";
    }
}
