package com.learn.playground.algorithm.sort;

public class QuickSort {

    public void quickSort(int[] numbers, int start, int end){
        if(start >= end){
            return;
        } else {
            int pivot = partition(numbers, start, end);
            quickSort(numbers, start, pivot - 1);
            quickSort(numbers, pivot + 1, end);
        }
    }

    private int partition(int[] numbers, int start, int end){
        int last = numbers[end];
        int result = start - 1;
        for(int index = start; index < end; index ++){
            if(numbers[index] <= last){
                result ++;
                int temp = numbers[result];
                numbers[result] = numbers[index];
                numbers[index] = temp;
            }
        }
        result ++;
        int temp = numbers[result];
        numbers[result] = numbers[end];
        numbers[end] = temp;
        return result;
    }
}
