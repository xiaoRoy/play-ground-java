package com.learn.playground.dependencyinjection.dagger.again;

import javax.annotation.Nonnull;

public class Student {

    @Nonnull
    private String firstName;

    @Nonnull
    private String lastName;

    public Student(@Nonnull String firstName, @Nonnull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Nonnull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Nonnull String firstName) {
        this.firstName = firstName;
    }

    @Nonnull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nonnull String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
