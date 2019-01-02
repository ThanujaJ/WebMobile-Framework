package com.tf.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement homePageLogo;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement m_homePageLogo;
}
