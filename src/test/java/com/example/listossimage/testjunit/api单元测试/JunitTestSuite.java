package com.example.listossimage.testjunit.api单元测试;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class JunitTestSuite {
    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite(TestJunit1.class, TestJunit2.class, TestJunit3.class);
        TestResult testResult = new TestResult();
        testSuite.run(testResult);

        System.out.println("Number of test cases = " + testResult.runCount());
    }
}
