package com.tf.flows;

import com.tf.pageObjects.LandingPageObjects;
import com.tf.utils.DeviceHelper;
import com.tf.utils.DeviceInterface;
import com.tf.utils.Messages;
import com.tf.utils.WebMessages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebFlow implements DeviceInterface {

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
    public Messages getMessages () {
        return new WebMessages();
    }

	@Override
	public void performLogin(String emailAddress, String pwd) {
		landingPageObjects.userName.sendKeys(emailAddress);
		landingPageObjects.password.sendKeys(pwd);
		landingPageObjects.clickLogin.click();
		
	}

	@Override
	public String getLoginErrorMessage() {
		
		return landingPageObjects.loginErrorMessage.getText();
	}


}
