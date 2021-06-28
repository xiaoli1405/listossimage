package com.example.listossimage.testjunit.api单元测试;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestJunit1 {

    @Test
    public void testAdd() {
        int num = 5;
        String temp = null;
        String str = "Junit is working fine";

        //检查平等
        assertEquals("Junit is working fine", str);

        //检查false
        assertFalse(num > 6);

        //检查是否非空的Value
        assertNotNull(str);
    }
}
