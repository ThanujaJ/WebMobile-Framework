package com.tf.testData;

import org.testng.annotations.DataProvider;

import com.tf.entities.LoginDetails;

public class TestData {
	@DataProvider
    public static Object[][] getLoginDetails () throws InterruptedException {

        	return new Object[][]{{new LoginDetails("xyz@gmail.com", "p@ssw0rd", "xyz@gmail.com", "jdduidjie")}};
}
	}