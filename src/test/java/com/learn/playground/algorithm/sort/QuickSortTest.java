package com.learn.playground.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void test_quick_sort(){
        QuickSort quickSort = new QuickSort();
        int[] numbers = {1, 9, 0, 12};
        quickSort.quickSort(numbers, 0, numbers.length - 1);
        Assert.assertArrayEquals(new int[]{0, 1, 9, 12}, numbers);
    }
}
