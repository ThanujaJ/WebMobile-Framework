package com.smava.utils;

import org.openqa.selenium.WebDriver;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }
}
