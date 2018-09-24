package com.learn.playground.dependencyinjection.injector;

import com.learn.playground.dependencyinjection.model.Computer;
import dagger.Component;

@Component
public interface ComputerComponent {

    Computer buildComputer();
}
