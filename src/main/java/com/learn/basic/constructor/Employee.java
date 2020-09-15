package com.learn.basic.constructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Employee extends Person {

    private String title;
    private List<String> words = new ArrayList();

    public Employee(String name, String title) {
//        super(what()); can not reference the what() before super-type constructor has been called
        super(name);
    }

    private String what() {
        return "what";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!title.equals(employee.title)) return false;
        return words.equals(employee.words);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + words.hashCode();
        return result;
    }
}
