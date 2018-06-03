package com.smava.entities;

/**
 * @author sudhanva on 6/1/18
 * @project smava
 */

public class LoanDetails {

    String loanAmount;
    String loanCategory;
    String loanDuration;
    Banks bank;

    public LoanDetails ( String loanAmount, String loanCategory, String loanDuration, Banks bank ) {
        this.loanAmount = loanAmount;
        this.loanCategory = loanCategory;
        this.loanDuration = loanDuration;
        this.bank = bank;
    }

    public String getLoanAmount () {
        return loanAmount;
    }

    public void setLoanAmount ( String loanAmount ) {
        this.loanAmount = loanAmount;
    }

    public String getLoanCategory () {
        return loanCategory;
    }

    public void setLoanCategory ( String loanCategory ) {
        this.loanCategory = loanCategory;
    }

    public String getLoanDuration () {
        return loanDuration;
    }

    public void setLoanDuration ( String loanDuration ) {
        this.loanDuration = loanDuration;
    }

    public Banks getBank () {
        return bank;
    }

    public void setBank ( Banks bank ) {
        this.bank = bank;
    }
}
