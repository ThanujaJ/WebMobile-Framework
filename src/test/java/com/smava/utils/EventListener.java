package com.smava.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */

public class EventListener extends AbstractWebDriverEventListener implements WebDriverEventListener {

    @Override
    public void beforeNavigateTo ( String url, WebDriver driver ) {
    }

    @Override
    public void afterNavigateTo ( String url, WebDriver driver ) {
        System.out.println("Running Tests On: " + url);
    }

    // Need to implement Extent Report functionality

    @Override
    public void onException ( Throwable throwable, WebDriver webdriver ) {
    }

    // Need to implement function to verify whether the element is stale.

    @Override
    public void beforeFindBy ( By by, WebElement element, WebDriver driver ) {
    }

    @Override
    public void afterFindBy ( By by, WebElement element, WebDriver driver ) {
    }

    // Before Click() function

    @Override
    public void beforeClickOn ( WebElement element, WebDriver driver ) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // After Click() function

    @Override
    public void afterClickOn ( WebElement element, WebDriver driver ) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Before SendKeys("") and Clear() functions


    @Override
    public void beforeChangeValueOf ( WebElement element, WebDriver driver, CharSequence[] keysToSend ) {
    }

    // After SendKeys("") and Clear() functions

    @Override
    public void afterChangeValueOf ( WebElement element, WebDriver driver, CharSequence[] keysToSend ) {
    }

    // Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[]) -- Need to check how it can be utilized

    @Override
    public void beforeScript ( String script, WebDriver driver ) {
        // TODO Auto-generated method stub
    }

    // Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[])

    @Override
    public void afterScript ( String script, WebDriver driver ) {
        // TODO Auto-generated method stub
    }
}
