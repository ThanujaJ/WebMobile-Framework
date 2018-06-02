package com.smava.utils;

import com.smava.flows.WebFlow;
import com.appium.manager.AppiumDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */

public class TestRunnerInfo {

    public DeviceInterface runnerInfo;
    static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    PropertyReader propertyReader;
    ViewFactory viewFactory;

    public TestRunnerInfo() {
        propertyReader = PropertyReader.getInstance();
        runnerInfo = runnerInfoStatus();
    }

    public DeviceInterface getRunnerInfo() {
        return runnerInfo;
    }

    public DeviceInterface runnerInfoStatus() {
        try {
            AppiumDriverManager.getDriver().getPlatformName();
            viewFactory = new ViewFactory(AppiumDriverManager.getDriver());
            runnerInfo = viewFactory.getMobilePlatform(AppiumDriverManager.getDriver().
                            getCapabilities().getCapability("platformName").toString(),
                    AppiumDriverManager.getDriver());
            driver.set(AppiumDriverManager.getDriver());
            return runnerInfo;
        } catch (Exception e) {
            driver.set(DriverManager.getDriver());
            return new WebFlow(DriverManager.getDriver());
        }
    }

    public WebDriver getDriverSession() {
        return driver.get();
    }
}
