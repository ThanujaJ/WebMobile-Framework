package com.tf.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tf.pageObjects.HomePageObjects;
import com.tf.utils.DeviceHelper;
import com.tf.utils.DeviceInterface;

public class HomePage {
	WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    HomePageObjects homePageObjects;

    public HomePage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        homePageObjects = new HomePageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, homePageObjects);
    }

	public boolean validateLogin() {
		return runnerInfo.validateLogin();
	}
}
