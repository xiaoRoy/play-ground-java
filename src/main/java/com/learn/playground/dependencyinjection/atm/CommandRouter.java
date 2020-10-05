package com.learn.playground.dependencyinjection.atm;

import com.learn.playground.dependencyinjection.atm.command.Command;
import com.learn.playground.dependencyinjection.atm.command.HelloWorldCommand;

import javax.annotation.Nonnull;
import javax.inject.Inject;
import java.util.*;

final public class CommandRouter {

    @Nonnull
    private final Map<String, Command> commands = new HashMap<>();

    @Inject
    CommandRouter(@Nonnull HelloWorldCommand helloWorldCommand) {
        commands.put(helloWorldCommand.key(), helloWorldCommand);
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
