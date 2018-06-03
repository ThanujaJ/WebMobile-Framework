package com.smava.tests;

import com.smava.pageActions.LandingPage;
import com.smava.utils.DeviceInterface;
import com.smava.utils.Messages;
import com.smava.utils.TestRunnerInfo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Sudhanva on 6/1/18
 * @project smava
 */
public class LoginTest {

    Messages messages;

    @Test
    public void loginWithInvalidCredentials () {

        System.setProperty("environment", "PROD");

        getLandingPage()
                .loadUrl()
                .performLogin("testUser@smava.com", "password");

        Assert.assertEquals(messages.getMessage("SignInErrorMessage"), getLandingPage().getLoginErrorMessage());
    }

    LandingPage getLandingPage () {
        WebDriver driverSession = new TestRunnerInfo().getDriverSession();
        DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
        messages = runnerInfo.getMessages();
        return new LandingPage(driverSession, runnerInfo);
    }
}
