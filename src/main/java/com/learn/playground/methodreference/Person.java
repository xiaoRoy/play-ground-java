package com.learn.playground.methodreference;

public class Person {

    public enum Sex{
        MALE, FEMALE
    }

    private Sex gender;

    private String name;

    private int age;

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int compareByAge(Person one, Person another){
        return one.getAge() - another.getAge();
    }
}
