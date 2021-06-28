package com.example.listossimage.testjunit.api单元测试;

import junit.framework.TestResult;
import org.junit.Test;

public class TestJunit3 extends TestResult {

    public synchronized void addError(Test test, Throwable t) {
        super.addError((junit.framework.Test) test, t);
    }

    @Test
    public void testAdd() {

    }

    public synchronized void stop() {

    }
}
