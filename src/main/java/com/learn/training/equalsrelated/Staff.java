package com.learn.training.equalsrelated;

public class Staff {

    private int age;

    private String name;

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;

        Staff staff = (Staff) another;

        if (age != staff.age) return false;
        return name != null ? name.equals(staff.name) : staff.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
