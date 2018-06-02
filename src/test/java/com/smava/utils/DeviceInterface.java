package com.smava.utils;

import com.smava.pageActions.LandingPage;
import com.smava.pageActions.ResultPage;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */
public interface DeviceInterface {
    Messages getMessages ();

    void enterLoanDetails ( String loanCategory, String loanAmount, String loanDuration ) throws InterruptedException;

    void viewLoanOptions ( String bankName );

    void performLogin(String emailAddress, String password);

    String getLoginErrorMessage();
}
