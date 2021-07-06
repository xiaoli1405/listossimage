package com.example.listossimage.java8新特性;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "", "jkl");
        List<String> filterStrings = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        for (String filterString : filterStrings) {
            System.out.println(filterString);
        }
    }

}
