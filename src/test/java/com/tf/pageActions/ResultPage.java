package com.tf.pageActions;

import com.tf.pageObjects.ResultPageObjects;
import com.tf.utils.DeviceHelper;
import com.tf.utils.DeviceInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ResultPage {

    WebDriver webDriver;
    DeviceHelper deviceHelper;
    DeviceInterface runnerInfo;
    ResultPageObjects resultPageObjects;

    public ResultPage ( WebDriver driver, DeviceInterface runnerInfo ) {
        this.webDriver = driver;
        deviceHelper = new DeviceHelper(driver);
        resultPageObjects = new ResultPageObjects();

        this.runnerInfo = runnerInfo;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, resultPageObjects);
    }

}
