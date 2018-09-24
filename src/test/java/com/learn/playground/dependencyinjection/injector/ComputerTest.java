package com.learn.playground.dependencyinjection.injector;


import org.junit.Assert;
import org.junit.Test;

public class ComputerTest {

    @Test
    public void test_get_keyboard(){
        ComputerComponent computerComponent = DaggerComputerComponent.create();
        Assert.assertNotNull(computerComponent.buildComputer().getKeyboard());
    }
}
