package com.example.listossimage.java8新特性;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * map方法用于映射每个元素到对应的结果，以下代码片段用于元素的平方数：
 */
public class MaoTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 6, 1, 9, 5, 3);
        //获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        //输出
        for (Integer integer : squaresList) {
            System.out.println(integer.toString());
        }
    }
}
