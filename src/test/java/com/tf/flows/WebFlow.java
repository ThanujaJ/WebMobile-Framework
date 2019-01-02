package com.tf.flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tf.pageObjects.HomePageObjects;
import com.tf.pageObjects.LandingPageObjects;
import com.tf.utils.DeviceHelper;
import com.tf.utils.DeviceInterface;
import com.tf.utils.Messages;
import com.tf.utils.WebMessages;

public class WebFlow implements DeviceInterface {

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LandingPageObjects landingPageObjects;
    HomePageObjects homePageObjects;

    public WebFlow ( WebDriver driver ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        landingPageObjects = new LandingPageObjects();
        homePageObjects = new HomePageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, landingPageObjects);
        PageFactory.initElements(driver, homePageObjects);
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

	@Override
	public boolean validateLogin() {
		return homePageObjects.homePageLogo.isDisplayed();
	}

}
