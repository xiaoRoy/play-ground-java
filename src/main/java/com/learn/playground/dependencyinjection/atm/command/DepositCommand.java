package com.learn.playground.dependencyinjection.atm.command;

import com.learn.playground.dependencyinjection.atm.data.Account;
import com.learn.playground.dependencyinjection.atm.data.AccountDataBase;
import com.learn.playground.dependencyinjection.atm.ouputter.Outputter;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

public class DepositCommand implements Command {

    @Nonnull
    private final Outputter outputter;

    @Nonnull
    private final AccountDataBase accountDataBase;

    @Inject
    public DepositCommand(@Nonnull Outputter outputter, @Nonnull AccountDataBase accountDataBase) {
        this.outputter = outputter;
        this.accountDataBase = accountDataBase;
    }

    @Nonnull
    @Override
    public String key() {
        return "deposit";
    }

    @Nonnull
    @Override
    public Status handleInput(@Nonnull List<String> inputs) {
        Status status;
        if (inputs.size() == 2) {
            String accountName = inputs.get(0);
            Account account = accountDataBase.getAccount(accountName);
            BigDecimal amount = toAmount(inputs.get(1));
            account.deposit(amount);
            status = Status.HANDLED;
            String message = account.getUserName() + " now has: " + account.getBalance();
            outputter.output(message);
        } else {
            status = Status.INVALID;
        }
        return status;
    }

    private BigDecimal toAmount(@Nonnull String amountInString) {
        BigDecimal result;
        try {
            result = new BigDecimal(amountInString);
        } catch (NumberFormatException exception) {
            result = BigDecimal.ZERO;
        }
        return result;
    }
}
