package com.smava.utils;

import com.smava.flows.MobileFlow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */

public class ViewFactory extends DeviceHelper {

    private MobileFlow mobileFlow;
    private static EventListener eventListener;
    private static EventFiringWebDriver e_driver;

    public ViewFactory ( WebDriver driver ) {
        super(driver);
    }

    public DeviceInterface getMobilePlatform ( String platform, AppiumDriver<MobileElement> driver ) {
        if (platform == null) {
            System.out.println("---Couldn't return a platform---");
            return null;
        }
        if (platform.equalsIgnoreCase("Android") || platform.equalsIgnoreCase("iOS") || platform.equalsIgnoreCase("LINUX")) {
            if (driver.getCapabilities().getCapability("browserName") != null) {

                e_driver = new EventFiringWebDriver(driver);
                eventListener = new EventListener();
                e_driver.register(eventListener);

                return mobileFlow = new MobileFlow(e_driver);
            } else {
                System.out.println("---Couldn't return a platform---");
            }
        }
        return null;
    }
}