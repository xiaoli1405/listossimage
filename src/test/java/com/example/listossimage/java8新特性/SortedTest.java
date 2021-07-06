package com.example.listossimage.java8新特性;

import java.util.Random;

/**
 *sorted方法用于对流进行排序。
 */
public class SortedTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints(10).sorted().forEach(System.out::println);
    }
}
