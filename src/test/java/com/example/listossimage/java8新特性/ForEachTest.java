package com.example.listossimage.java8新特性;

import java.util.Random;

/**
 * Stream提供了新方法‘forEach来迭代流中的每个数据。一下代码片段使用forEach输出了10个随机数’
 */
public class ForEachTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}
