package com.learn.playground.dependencyinjection.phone;

import dagger.Module;
import dagger.Provides;

import java.util.Random;

@Module
public class DisplayModule {

    @Provides
    Display provideDisplay() {
        Random random = new Random();
        boolean isEven = random.nextInt() % 2 == 0;
        Display display;
        if(isEven) {
            display = new Display.LcdDisplay();
        } else {
            display = new Display.OledDisplay();
        }
        return display;
    }
}
