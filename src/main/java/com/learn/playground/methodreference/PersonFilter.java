package com.learn.playground.methodreference;

public class PersonFilter {

    public boolean filterAdult(Person person){
        return person.getAge() >= 18;
    }
}
