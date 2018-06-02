package com.smava.flows;

import com.smava.pageObjects.LandingPageObjects;
import com.smava.utils.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */
public class MobileFlow implements DeviceInterface{

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LandingPageObjects landingPageObjects;

    public MobileFlow(WebDriver driver){
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        landingPageObjects = new LandingPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, landingPageObjects);
    }

    @Override
    public Messages getMessages(){
        return new MobileMessages();
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
        deviceHelper.selectDropdownByText(landingPageObjects.m_loanAmount, loanAmount + " €" );

        deviceHelper.selectDropdownByText(landingPageObjects.m_loanDuration, loanDuration + " Monate" );

        deviceHelper.selectDropdownByText(landingPageObjects.m_loanCategory, loanCategory );

        landingPageObjects.compare.click();
    }

    @Override
    public void viewLoanOptions ( String bankName ){
        deviceHelper.waitTillTheElementIsVisibleAndClickable(continueBtn(bankName));

        continueBtn(bankName).click();
    }

    @Override
    public void performLogin(String emailAddress, String password){

        landingPageObjects.m_menuIcon.click();

        landingPageObjects.m_anmeldenLink.click();

        landingPageObjects.m_emailAddress.sendKeys(emailAddress);

        landingPageObjects.m_password.sendKeys(password);

        landingPageObjects.m_anmeldenButton.click();
    }

    @Override
    public String getLoginErrorMessage(){
        return landingPageObjects.loginErrMessage.getText();
    }
}
