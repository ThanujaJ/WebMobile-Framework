package com.tf.utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void setDriver ( WebDriver driver ) {
        webDriver.set(driver);
    }

    public static WebDriver getDriver () {
        return webDriver.get();
    }
}
