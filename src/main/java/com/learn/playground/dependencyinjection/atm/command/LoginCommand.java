package com.learn.playground.dependencyinjection.atm.command;

import com.learn.playground.dependencyinjection.atm.data.Account;
import com.learn.playground.dependencyinjection.atm.data.AccountDataBase;
import com.learn.playground.dependencyinjection.atm.ouputter.Outputter;

import javax.annotation.Nonnull;
import javax.inject.Inject;

final public class LoginCommand extends SingleArgumentCommand {

    @Nonnull
    private final Outputter outputter;

    @Nonnull
    private final AccountDataBase accountDataBase;

    @Inject
    public LoginCommand(@Nonnull AccountDataBase accountDataBase, @Nonnull Outputter outputter) {
        this.accountDataBase = accountDataBase;
        this.outputter = outputter;
    }

    @Override
    protected Status handleSingeArgument(@Nonnull String userName) {
        Account account = accountDataBase.getAccount(userName);
        String message = userName + " is logged in with balance: " + account.getBalance();
        outputter.output(message);
        return Status.HANDLED;
    }

    @Nonnull
    @Override
    public String key() {
        return "login";
    }
}
