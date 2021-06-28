package com.example.listossimage.testjunit.使用断言;

import org.junit.*;

public class JunitAnnotation {

    @AfterClass
    public static void afterClass() {
        System.out.println("in after class");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    @Ignore
    public void ignoreTest() {
        System.out.println("in ignore test");
    }
}
