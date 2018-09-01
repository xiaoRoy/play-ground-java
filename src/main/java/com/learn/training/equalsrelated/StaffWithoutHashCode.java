package com.learn.training.equalsrelated;

public class StaffWithoutHashCode {

    private int age;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffWithoutHashCode that = (StaffWithoutHashCode) o;

        if (age != that.age) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    /*@Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }*/
}
