package com.tf.utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestFactory {
    private static ThreadLocal<ExtentTest> extentPool = new ThreadLocal<ExtentTest>();

    public static void setExtentTest ( ExtentTest extentTest ) {
        extentPool.set(extentTest);
    }

    public static ExtentTest getExtentTest () {
        return extentPool.get();
    }
}
