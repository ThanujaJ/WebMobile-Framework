package com.smava.pageActions;

import com.smava.pageObjects.LandingPageObjects;
import com.smava.utils.DeviceHelper;
import com.smava.utils.DeviceInterface;
import com.smava.utils.URLGetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sudhanva on 5/31/18
 * @project smava
 */
public class LandingPage {

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LandingPageObjects landingPageObjects;

    public LandingPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        landingPageObjects = new LandingPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, landingPageObjects);
    }

    public WebElement continueBtn ( String bankName ) {

        return webDriver.findElement(By.id("forwardButton" + bankName.toLowerCase()));
    }

    public WebElement loanDurationValue ( String months ) {
        return webDriver.findElement(By.xpath("//div[text()='" + months + " Monate']"));
    }

    public WebElement loanCategoryValue ( String category ) {
        return webDriver.findElement(By.xpath("//div[text()='" + category + "']"));
    }

    public LandingPage loadUrl () {

        URLGetter urlGetter = new URLGetter();

        String url = urlGetter.getURLs("APP_URL");

        webDriver.navigate().to(url);

        return this;
    }

    public LandingPage enterLoanDetails ( String loanCategory, String loanAmount, String loanDuration ) throws InterruptedException {
        runnerInfo.
                enterLoanDetails(loanCategory, loanAmount, loanDuration);
        return this;
    }

    public ResultPage viewLoanOptions ( String bankName ) {

        runnerInfo
                .viewLoanOptions(bankName);

        return new ResultPage(webDriver, runnerInfo);
    }

    public void performLogin ( String emailAddress, String password ) {

        runnerInfo.performLogin(emailAddress, password);
    }

    public String getLoginErrorMessage () {
        return runnerInfo.getLoginErrorMessage();

    }

}
