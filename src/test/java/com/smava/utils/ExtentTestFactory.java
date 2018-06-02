package com.smava.utils;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */

public class ExtentTestFactory {
    private static ThreadLocal<ExtentTest> extentPool = new ThreadLocal<ExtentTest>();

    public static void setExtentTest(ExtentTest extentTest) {
        extentPool.set(extentTest);
    }

    public static ExtentTest getExtentTest() {
        return extentPool.get();
    }
}
