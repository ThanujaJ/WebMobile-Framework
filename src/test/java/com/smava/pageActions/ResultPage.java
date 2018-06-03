package com.smava.pageActions;

import com.smava.entities.LoanDetails;
import com.smava.pageObjects.ResultPageObjects;
import com.smava.utils.DeviceHelper;
import com.smava.utils.DeviceInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author Sudhanva on 5/31/18
 * @project smava
 */
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

    public Boolean verifyLoanDetails ( LoanDetails loanDetails ) {

        Assert.assertEquals(deviceHelper.getSelectedValueFromDropDown(resultPageObjects.loanCategory), loanDetails.getLoanCategory(), "Mismatch in loan category");
        Assert.assertEquals(deviceHelper.getSelectedValueFromDropDown(resultPageObjects.loanAmount).replace(".", ""), loanDetails.getLoanAmount().replace(".", "") + " €", "Mismatch in loan amount");
        Assert.assertEquals(deviceHelper.getSelectedValueFromDropDown(resultPageObjects.loanDuration), loanDetails.getLoanDuration() + " Monate", "Mismatch in loan duration");
        return true;
    }
}
