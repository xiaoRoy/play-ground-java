package com.learn.playground.dependencyinjection.phone;

import javax.annotation.Nonnull;
import javax.inject.Inject;

public class Phone {

    @Nonnull
    @Inject
    Display display;

    @Inject
    public Phone() {
    }

    @Nonnull
    public Display getDisplay() {
        return display;
    }

    public void setDisplay(@Nonnull Display display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "display=" + display +
                '}';
    }

    public static void main(String[] args) {
        Phone phone = DaggerPhoneComponent.create().injectDisplay();
        System.out.println(phone);
    }
}
