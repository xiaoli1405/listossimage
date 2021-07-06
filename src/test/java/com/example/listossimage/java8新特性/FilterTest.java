package com.example.listossimage.java8新特性;

import java.util.Arrays;
import java.util.List;

/**
 * filter用于通过设置条件过滤元素。以下代码过滤空字符串并计算数量
 */
public class FilterTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "", "jkl");
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }
}
