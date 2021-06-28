package com.example.listossimage.testjunit.忽略测试;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestJunit {

    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Ignore
    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = "Robert";
        assertEquals(message, messageUtil.printMessage());
    }

    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
        assertEquals(message, messageUtil.salutationMessage());
    }
}
