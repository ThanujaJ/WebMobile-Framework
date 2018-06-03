package com.smava.testData;

import com.smava.entities.Banks;
import com.smava.entities.LoanDetails;
import org.testng.annotations.DataProvider;

/**
 * @author Sudhanva on 6/1/18
 * @project smava
 */
public class TestData {

    @DataProvider
    public static Object[][] getLoanDetails () throws InterruptedException {
        return new Object[][]{
                {new LoanDetails("2.750", "Wohnen", "24", Banks.SWK_BANK)},
        };
    }
}
