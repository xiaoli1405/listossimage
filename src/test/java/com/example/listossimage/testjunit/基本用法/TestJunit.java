package com.example.listossimage.testjunit.基本用法;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {

    String message = "hello word";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        message = "new word";
        assertEquals(message, messageUtil.printMessage());
    }
}
