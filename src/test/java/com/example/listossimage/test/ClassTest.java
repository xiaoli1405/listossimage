package com.example.listossimage.test;

public class ClassTest {

    public ClassTest() {
        System.out.println("构造器");
    }
    static {
        System.out.println("static代码块");
    }
    {
        System.out.println("类代码块");
    }

    public static void main(String[] args) {
        new ClassTest();
    }
}
