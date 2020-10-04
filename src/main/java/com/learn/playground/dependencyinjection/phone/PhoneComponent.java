package com.learn.playground.dependencyinjection.phone;

import dagger.Component;

import javax.annotation.Nonnull;

@Component(modules = {DisplayModule.class})
public interface PhoneComponent {

    @Nonnull
    Phone injectDisplay();
}
