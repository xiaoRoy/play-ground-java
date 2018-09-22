package com.learn.training.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamShowcase {

    private void streamMap(){
        List<Integer> result =
                Stream.of(1, 2, 5, 6)
                .map(number -> number * number)
                .distinct()
                .collect(Collectors.toList());
    }

    private void streamFilter(){
        List<String> result =
                Stream.of("", "A", "NBA")
                .filter(String::isEmpty)
                .collect(Collectors.toList());

    }

    private void streamSort(){
        Stream.of(1, 3, 19, 2).sorted(Integer::compareTo);
    }
}
