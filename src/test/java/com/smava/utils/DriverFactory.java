package com.smava.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.logging.Level;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */

public class DriverFactory {

    private static EventFiringWebDriver e_driver;
    private static EventListener eventListener;

    public static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);

        switch(browserName.toLowerCase()){
            case "chrome":

                System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-fullscreen");
                options.addArguments("--lang=en");
                driver = new ChromeDriver(options);
                break;

            case "firefox":

                System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;

            case "edge":

            break;

            case "ie":

                break;

            case "safari":

                break;


        }

        e_driver = new EventFiringWebDriver(driver);
        eventListener = new EventListener();
        e_driver.register(eventListener);

        return e_driver;
    }
}
