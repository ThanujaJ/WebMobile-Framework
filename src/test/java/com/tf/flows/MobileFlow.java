package com.tf.flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tf.pageObjects.LandingPageObjects;
import com.tf.utils.DeviceHelper;
import com.tf.utils.DeviceInterface;
import com.tf.utils.Messages;
import com.tf.utils.MobileMessages;

public class MobileFlow implements DeviceInterface {

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    LandingPageObjects landingPageObjects;

    public MobileFlow ( WebDriver driver ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        landingPageObjects = new LandingPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, landingPageObjects);
    }

    @Override
    public Messages getMessages () {
        return new MobileMessages();
    }

	@Override
	public void performLogin(String emailAddress, String pwd) {
		landingPageObjects.m_userName.sendKeys(emailAddress);
		landingPageObjects.m_password.sendKeys(pwd);
		landingPageObjects.m_clickLogin.click();
		
	}

	@Override
	public String getLoginErrorMessage() {
		return landingPageObjects.m_loginErrorMessage.getText();
	}

}
