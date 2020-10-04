package com.learn.playground.dependencyinjection.atm;

import java.util.Scanner;

public class AtmApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandRouter commandRouter = new CommandRouter();
        while (scanner.hasNext()) {
            commandRouter.route(scanner.nextLine());
        }
    }
}
