package com.learn.playground.dependencyinjection.atm;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final public class CommandRouter {

    @Nonnull
    private final Map<String, Command> commands = Collections.emptyMap();

    @Inject
    CommandRouter() {
    }

    @Nonnull
    Command.Status route(@Nonnull String input) {
        Command.Status status;
        List<String> inputSlices = split(input);
        if(inputSlices.isEmpty()) {
            status = invalidCommand(input);
        }  else {
            String commandKey = inputSlices.get(0);
            Command command = commands.get(commandKey);
            if(command == null) {
                status = invalidCommand(input);
            } else {
                List<String> commandArguments = inputSlices.subList(1, inputSlices.size());
                status = command.handleInput(commandArguments);
                if(Command.Status.INVALID == status) {
                    System.out.println(commandKey + ": invalid arguments");
                }
            }
        }
        return status;

    }

    private Command.Status invalidCommand(@Nonnull String input) {
        String message = String.format("Couldn't understand \"%1$s\". Please try again.", input);
        System.out.println(message);
        return Command.Status.INVALID;
    }

    @Nonnull
    private static List<String> split(@Nonnull String input) {
        return Arrays.asList(input.trim().split("\\s+"));
    }
}
