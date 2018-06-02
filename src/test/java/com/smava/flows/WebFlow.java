package com.smava.flows;

import com.smava.pageActions.LandingPage;
import com.smava.pageObjects.LandingPageObjects;
import com.smava.utils.DeviceHelper;
import com.smava.utils.DeviceInterface;
import com.smava.utils.Messages;
import com.smava.utils.WebMessages;
import com.thoughtworks.device.DeviceManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */
public class WebFlow implements DeviceInterface{

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LandingPageObjects landingPageObjects;

    public WebFlow ( WebDriver driver ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        landingPageObjects = new LandingPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, landingPageObjects);
    }

    @Override
    public Messages getMessages(){
        return new WebMessages();
    }

    private WebElement continueBtn ( String bankName ) {

        return webDriver.findElement(By.id("forwardButton" + bankName.toLowerCase()));
    }

    private WebElement loanDurationValue ( String months ) {
        return webDriver.findElement(By.xpath("//div[text()='" + months + " Monate']"));
    }

    private WebElement loanCategoryValue ( String category ) {
        return webDriver.findElement(By.xpath("//div[text()='" + category + "']"));
    }

    @Override
    public void enterLoanDetails( String loanCategory, String loanAmount, String loanDuration ) throws InterruptedException
    {
        landingPageObjects.loanAmount.click();
        landingPageObjects.loanAmount.sendKeys(loanAmount.replace(".",""));
        landingPageObjects.loanAmount.sendKeys(Keys.ENTER);

        landingPageObjects.loanDuration.click();
        deviceHelper.waitForElementToAppear(loanDurationValue(loanDuration));
        loanDurationValue(loanDuration).click();

        landingPageObjects.loanDuration.sendKeys(Keys.TAB);
        loanCategoryValue(loanCategory).click();
    }

    @Override
    public void viewLoanOptions ( String bankName ){
        deviceHelper.waitTillTheElementIsVisibleAndClickable(continueBtn(bankName));

        continueBtn(bankName).click();
    }

    @Override
    public void performLogin(String emailAddress, String password){

        landingPageObjects.anmeldenLink.click();

        landingPageObjects.emailAddress.sendKeys(emailAddress);

        landingPageObjects.password.sendKeys(password);

        landingPageObjects.anmeldenButton.click();
    }

    @Override
    public String getLoginErrorMessage(){
        return landingPageObjects.loginErrMessage.getText();
    }
}
