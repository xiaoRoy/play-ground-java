package com.learn.training.stream;

import java.util.Optional;

public class LearnOptional {

    private void xX(){
        Optional<String> stringOptional = Optional.of("name");
        stringOptional.ifPresent(String::toUpperCase);
    }
}
