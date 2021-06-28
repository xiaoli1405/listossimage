package com.example.listossimage.testjunit.使用断言;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAssertions {

    @Test
    public void testAssertions() {
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String [] expectedArray = {"one", "two", "three"};


        assertEquals(str1, str2);
    }
}
