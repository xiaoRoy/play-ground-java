package com.learn.playground.dependencyinjection.atm.data;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class AccountDataBase {

    @Nonnull
    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    public AccountDataBase() {

    }

    @Nonnull
    public Account getAccount(@Nonnull String userName) {
        return accounts.computeIfAbsent(userName, Account::new);
    }
}
