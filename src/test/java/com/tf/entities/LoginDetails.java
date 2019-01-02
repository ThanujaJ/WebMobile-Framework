package com.tf.entities;

public class LoginDetails {
	String validEmailId;
	String validPassword;
	String invalidEmailId;
	String invalidPassword;

    public LoginDetails ( String validEmailId, String validPassword, String invalidEmailId, String invalidPassword) {
        this.validEmailId = validEmailId;
        this.invalidEmailId = invalidEmailId;
        this.validPassword = validPassword;
        this.invalidPassword = invalidPassword;
    }

    public String getValidEmailId () {
        return validEmailId;
    }

    public void setValidEmailId ( String validEmailId ) {
        this.validEmailId = validEmailId;
    }
    
    public String getInvalidEmailId () {
        return invalidEmailId;
    }

    public void setInvaliEmailId ( String invalidEmailId ) {
        this.invalidEmailId = invalidEmailId;
    }
    
    public String getValidPassword () {
        return validPassword;
    }

    public void setValidPassword ( String validPassword ) {
        this.validPassword = validPassword;
    }
    
    public String getInvalidPassword () {
        return invalidPassword;
    }

    public void setInvalidPassword ( String invalidPassword ) {
        this.invalidPassword = invalidPassword;
    }
}
