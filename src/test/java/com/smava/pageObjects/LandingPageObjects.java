package com.smava.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */
public class LandingPageObjects {

    @FindBy(xpath = "//div[@id='myselect']//input")
    public WebElement loanAmount;

    @FindBy(id = "lsAmount")
    public WebElement m_loanAmount;

    @FindBy(xpath = "//a[@class='item menu-accor hide show-1200']")
    public WebElement m_menuIcon;

    @FindBy(xpath = "//div[@id='myselect2']//input")
    public WebElement loanDuration;

    @FindBy(id = "lsDuration")
    public WebElement m_loanDuration;

    @FindBy(id = "lsCategory")
    public WebElement m_loanCategory;

    @FindBy(id = "loanSelectionForward")
    public WebElement compare;

    @FindBy(xpath = "//div[@class='title login']")
    public WebElement m_anmeldenLink;

    @FindBy(xpath = "//a[text()='Anmelden']")
    public WebElement anmeldenLink;

    @FindBy(id = "signonForm.email")
    public WebElement emailAddress;

    @FindBy(xpath = "//form[@class='signonForm signonFormMobile transition visible']//input[@id='signonForm.email']")
    public WebElement m_emailAddress;

    @FindBy(id = "signonForm.password")
    public WebElement password;

    @FindBy(xpath = "//form[@class='signonForm signonFormMobile transition visible']//input[@id='signonForm.password']")
    public WebElement m_password;

    @FindBy(xpath = "//button[contains(@onclick, 'Mobile')]//div[@id='cta-label']")
    public WebElement m_anmeldenButton;

    @FindBy(id = "cta-label")
    public WebElement anmeldenButton;

    @FindBy(xpath = "//div[@class='box-wrapper error']//li")
    public WebElement loginErrMessage;
}
