package com.tf.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPageObjects {
	
	@FindBy(xpath = "//div[contains(text(),'Invalid login credentials')]")
	public WebElement loginErrorMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Invalid login credentials')]")
	public WebElement m_loginErrorMessage;
	
	@FindBy(id = "_tfocuslogin_WAR_TFportlet_login")
	public WebElement userName;
	
	@FindBy(id = "_tfocuslogin_WAR_TFportlet_password")
	public WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	public WebElement clickLogin;
	
	@FindBy(id = "_tfocuslogin_WAR_TFportlet_login")
	public WebElement m_userName;
	
	@FindBy(id = "_tfocuslogin_WAR_TFportlet_password")
	public WebElement m_password;
	
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	public WebElement m_clickLogin;
}
