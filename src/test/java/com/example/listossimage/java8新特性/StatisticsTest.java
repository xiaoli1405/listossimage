package com.example.listossimage.java8新特性;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StatisticsTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 4, 7, 3, 5);
        IntSummaryStatistics statistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数：" + statistics.getMax());
        System.out.println("列表中最小的数：" + statistics.getMin());
        System.out.println("列表数之和:" + statistics.getSum());
        System.out.println("平均数:" + statistics.getAverage());
    }
}
