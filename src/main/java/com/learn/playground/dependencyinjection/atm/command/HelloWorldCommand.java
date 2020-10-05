package com.learn.playground.dependencyinjection.atm.command;

import com.learn.playground.dependencyinjection.atm.ouputter.Outputter;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.List;

public class HelloWorldCommand implements Command {

    @Nonnull
    private final Outputter outputter;


    @Inject
    public HelloWorldCommand(@Nonnull Outputter outputter) {
        this.outputter = outputter;
    }

    @Nonnull
    @Override
    public String key() {
        return "hello";
    }

    @Nonnull
    @Override
    public Status handleInput(@Nonnull List<String> inputs) {
        Status status;
        if(inputs.isEmpty()) {
            status = Status.HANDLED;
            System.out.println("world");
        } else {
            status = Status.INVALID;
        }
        return status;
    }
}
