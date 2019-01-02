package com.tf.pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tf.pageObjects.LandingPageObjects;
import com.tf.utils.DeviceHelper;
import com.tf.utils.DeviceInterface;
import com.tf.utils.URLGetter;

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

    public LandingPage loadUrl () {

        URLGetter urlGetter = new URLGetter();

        String url = urlGetter.getURLs("APP_URL");
        System.out.println(url);
        webDriver.navigate().to(url);

        return this;
    }

    public void performLogin ( String emailAddress, String password ) {

        runnerInfo.performLogin(emailAddress, password);
    }

    public String getLoginErrorMessage () {
        return runnerInfo.getLoginErrorMessage();

    }

}
