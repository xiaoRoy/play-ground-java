package com.learn.playground.dependencyinjection.atm.data;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

public class Account {

    @Nonnull
    private final String userName;

    @Nonnull
    private BigDecimal balance = BigDecimal.ZERO;

    public Account(@Nonnull String userName) {
        this.userName = userName;
    }

    @Nonnull
    public String getUserName() {
        return userName;
    }

    @Nonnull
    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(@Nonnull BigDecimal amount) {
        balance = balance.add(amount);
    }
}
