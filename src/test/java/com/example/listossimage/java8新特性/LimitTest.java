package com.example.listossimage.java8新特性;

import java.util.Random;

/**
 * limit方法用于指定数量的流。一下代码片段使用limit方法打印出10条数据
 */
public class LimitTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}
