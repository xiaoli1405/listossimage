package com.example.listossimage.java8新特性;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "" , "bc", "efg", "abcd", "", "jkl");
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }
}
