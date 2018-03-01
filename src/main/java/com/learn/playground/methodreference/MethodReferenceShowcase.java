package com.learn.playground.methodreference;

import java.util.List;

public class MethodReferenceShowcase {

    //A method reference to an instance method of an arbitrary type
    private void upperName(List<Person> people){
        people.stream()
                .map(Person::getName)
                .map(String::toUpperCase);
    }

    //A method reference to an instance method of an arbitrary type
    private void sortByName(List<String> names){
        names.sort(String::compareTo);
    }

    //A method reference to a static method
    private void sortByAge(List<Person> people){
        people.sort(Person::compareByAge);
    }

    //A method reference to an instance method of an existing object
    private void filterByAge(List<Person> people){
        final PersonFilter personFilter = new PersonFilter();
        people.stream()
                .filter(personFilter::filterAdult);
    }
}
