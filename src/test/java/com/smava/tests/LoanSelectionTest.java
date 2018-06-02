package com.smava.tests;

import com.smava.entities.Banks;
import com.smava.entities.LoanDetails;
import com.smava.pageActions.LandingPage;
import com.smava.pageActions.ResultPage;
import com.smava.testData.TestData;
import com.smava.utils.DeviceInterface;
import com.smava.utils.TestRunnerInfo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Sudhanva on 5/31/18
 * @project smava
 */
public class LoanSelectionTest {

    ResultPage resultPage;

    @Test(dataProvider = "getLoanDetails", groups = {"Regression"}, dataProviderClass = TestData.class)
    public void applyForLoan( LoanDetails loanDetails) throws InterruptedException {

        System.setProperty("environment", "PROD");

        getLandingPage()

                .loadUrl()

                .enterLoanDetails(loanDetails.getLoanCategory(), loanDetails.getLoanAmount(), loanDetails.getLoanDuration())

                .viewLoanOptions(loanDetails.getBank().toString());

        Assert.assertTrue(resultPage.verifyLoanDetails(loanDetails), "Loan details on result page doesn't match the loan details provided on landing page");
    }

    LandingPage getLandingPage(){
        WebDriver driverSession = new TestRunnerInfo().getDriverSession();
        DeviceInterface runnerInfo = new TestRunnerInfo().getRunnerInfo();
        resultPage = new ResultPage(driverSession, runnerInfo);
        return new LandingPage(driverSession, runnerInfo);
    }
}
