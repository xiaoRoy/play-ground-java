package com.learn.playground.dependencyinjection.phone;

import javax.annotation.Nonnull;

public abstract class Display {

    @Nonnull
    public abstract String getType();

    @Override
    public String toString() {
        return getType();
    }

    public static class LcdDisplay extends Display {
        @Nonnull
        @Override
        public String getType() {
            return "LCD";
        }
    }

    public static class OledDisplay extends Display {
        @Nonnull
        @Override
        public String getType() {
            return "Oled";
        }
    }
}
