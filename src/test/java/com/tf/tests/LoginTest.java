package com.tf.tests;

import com.tf.testData.TestData;
import com.tf.entities.LoginDetails;
import com.tf.pageActions.HomePage;
import com.tf.pageActions.LandingPage;
import com.tf.utils.DeviceInterface;
import com.tf.utils.Messages;
import com.tf.utils.TestRunnerInfo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    Messages messages;
    HomePage homePage;

    @Test(dataProvider = "getLoginDetails", groups = { "Regression" }, dataProviderClass = TestData.class)
    public void loginWithInvalidCredentials (LoginDetails loginDetails) {

        System.setProperty("environment", "PROD");

        getLandingPage()
                .loadUrl()
                .performLogin(loginDetails.getInvalidEmailId(), loginDetails.getInvalidPassword());

        Assert.assertEquals(messages.getMessage("SignInErrorMessage"), getLandingPage().getLoginErrorMessage());
    }
    
    @Test(dataProvider = "getLoginDetails", groups = { "Regression" }, dataProviderClass = TestData.class)
    public void loginWithValidCredentials (LoginDetails loginDetails) {

        System.setProperty("environment", "PROD");

        getLandingPage()
                .loadUrl()
                .performLogin(loginDetails.getValidEmailId(), loginDetails.getValidPassword());

       Assert.assertTrue(homePage.validateLogin(), "Login Failed");
    }

    LandingPage getLandingPage () {
        WebDriver driverSession = new TestRunnerInfo().getDriverSession();
        DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
        homePage = new HomePage(driverSession, runnerInfo);
        messages = runnerInfo.getMessages();
        return new LandingPage(driverSession, runnerInfo);
    }
}
