package com.learn.playground.codelab;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestSplitStringList {

    private static List<String> sTexts = Arrays.asList("one", "two", "three");


    @Test
    public void test_join_by_comma(){
        SplitStringList splitStringList = new SplitStringList();
        String result = splitStringList.joinBy(",", sTexts);
        Assert.assertEquals(result, "one,two,three");
    }

    @Test
    public void test_sjoin_manually(){
        SplitStringList splitStringList = new SplitStringList();
        String result = splitStringList.collectionToDelimited(",", sTexts);
        Assert.assertEquals(result, "one,two,three");
    }

    @Test
    public void test_join_with_stream(){
        SplitStringList splitStringList = new SplitStringList();
        String result = splitStringList.joinWithStream(",", sTexts);
        Assert.assertEquals(result, "one,two,three");
    }
}
