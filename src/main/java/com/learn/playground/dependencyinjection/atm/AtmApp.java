package com.learn.playground.dependencyinjection.atm;

import com.learn.playground.dependencyinjection.atm.dependency.CommandRouterComponent;
import com.learn.playground.dependencyinjection.atm.dependency.DaggerCommandRouterComponent;

import java.util.Scanner;

public class AtmApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandRouterComponent commandRouterComponent = DaggerCommandRouterComponent.create();
        CommandRouter commandRouter = commandRouterComponent.router();
        while (scanner.hasNext()) {
            commandRouter.route(scanner.nextLine());
        }
    }
}
