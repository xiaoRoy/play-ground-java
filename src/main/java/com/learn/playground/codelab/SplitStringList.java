package com.learn.playground.codelab;

import javax.swing.text.html.HTMLDocument;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SplitStringList {

    public String joinBy(String delimiter, List<String> texts){
        return String.join(delimiter, texts);
    }

    public String collectionToDelimited(String delimiter, List<String> texts){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = texts.iterator();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
            if(iterator.hasNext()){
                stringBuilder.append(delimiter);
            }
        }
        return stringBuilder.toString();
    }

    public String joinWithStream(String delimiter, List<String> texts){
        return texts.stream().collect(Collectors.joining(delimiter));
    }
}
