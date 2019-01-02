package com.tf.utils;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DeviceHelper {

    PropertyReader propertyReader;
    public WebDriver driver;

    public DeviceHelper ( WebDriver driver ) {
        propertyReader = PropertyReader.getInstance();
        this.driver = driver;
    }

    public boolean waitTillTheElementIsVisibleAndClickable ( WebElement element ) {

        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOf(element));

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        return true;
    }

    public static void selectDropdownByText ( WebElement dropDownelement, String textValue ) {
        Select select = new Select(dropDownelement);
        select.selectByVisibleText(textValue);
        select = null;
    }

    public static void selectDropdownByIndex ( WebElement dropDownelement, int indexValue ) {
        Select select = new Select(dropDownelement);
        select.selectByIndex(indexValue);
        select = null;
    }

    public static void selectDropdownByValue ( WebElement dropDownelement, String value ) {
        Select select = new Select(dropDownelement);
        select.selectByValue(value);
        select = null;
    }

    public static String getSelectedValueFromDropDown ( WebElement element ) {
        Select select = new Select(element);
        WebElement option = select.getFirstSelectedOption();
        return option.getText();
    }


    public static String AcceptAlert ( WebDriver driver ) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return alert.getText();
    }

    public static String DismissAlert ( WebDriver driver ) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        return alert.getText();
    }

    public boolean waitForStaleElement ( WebElement element ) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.stalenessOf(element));

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));

        return true;
    }

    public void waitTillTheElementInVisible ( WebElement element ) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForPageToLoad ( WebElement id ) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void waitForElementState ( WebElement id ) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.stalenessOf(id));

        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void waitForPageToLoad ( List<WebElement> id ) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
    }

    public void waitForElementToDisAppear ( List<WebElement> id ) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfAllElements(id));
    }

    public void waitForElementToDisAppear ( List<WebElement> id, int timeout ) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfAllElements(id));
    }

    public WebElement waitForElementToAppear ( WebElement id ) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }

    public WebElement waitForElementToAppear ( WebElement id, int timeout ) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(id));
        return id;
    }

    public WebElement waitForElement ( WebElement arg ) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    public void WaitForFrameAndSwitchToIt ( String id ) {
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public void waitForFrameAndSwitchToIt ( int id ) {
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public void scrollToElement ( WebElement element ) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
