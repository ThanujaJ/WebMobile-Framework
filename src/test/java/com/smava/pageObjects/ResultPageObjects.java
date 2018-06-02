package com.smava.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sudhanva on 5/31/18
 * @project smava
 */
public class ResultPageObjects {

    @FindBy(id="applicant0.loan.selection.category")
    public WebElement loanCategory;

    @FindBy(id="applicant0.loan.selection.amount")
    public WebElement loanAmount;

    @FindBy(id="applicant0.loan.selection.duration")
    public WebElement loanDuration;
}

