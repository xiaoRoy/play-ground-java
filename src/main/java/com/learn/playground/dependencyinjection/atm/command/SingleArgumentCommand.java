package com.learn.playground.dependencyinjection.atm.command;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class SingleArgumentCommand implements Command {


    @Nonnull
    @Override
    public Status handleInput(@Nonnull List<String> inputs) {
        return inputs.size() == 1 ? handleSingeArgument(inputs.get(0)) : Status.INVALID;
    }


    protected abstract Status handleSingeArgument(@Nonnull String arg);
}
