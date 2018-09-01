package com.learn.playground.training;

import com.learn.training.equalsrelated.LearnStringCache;
import org.junit.Assert;
import org.junit.Test;

public class LearnStringCacheTest {

    @Test
    public void test_string_cache(){

        String one = "abc";
        String another = "abc";

        LearnStringCache learnStringCache = new LearnStringCache();
        boolean result = learnStringCache.isXxx(one, another);
        Assert.assertTrue(result);

    }

    @Test
    public void test_string_new_instance(){

        String one = new String("abc");
        String another = new String("abc");

        LearnStringCache learnStringCache = new LearnStringCache();
        boolean result = learnStringCache.isXxx(one, another);
        Assert.assertFalse(result);

    }
}
