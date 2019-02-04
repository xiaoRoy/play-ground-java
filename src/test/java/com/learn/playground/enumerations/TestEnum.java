package com.learn.playground.enumerations;

import org.junit.Assert;
import org.junit.Test;

public class TestEnum {

    @Test
    public void test_values() {
        Assert.assertEquals(7, Day.values().length);
        Day.valueOf("a");
    }

    @Test
    public void test_valueOf() {
        Day monday = Day.valueOf("MONDAY");
        Assert.assertEquals(Day.MONDAY, monday);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_valueOf_notExist() {
        Day.valueOf("Not a Day");
    }

    @Test
    public void test_original_value() {
        Assert.assertEquals(1, Day.MONDAY.ordinal());
    }

}
