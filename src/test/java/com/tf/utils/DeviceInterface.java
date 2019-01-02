package com.tf.utils;

public interface DeviceInterface {
    Messages getMessages ();

    void performLogin ( String emailAddress, String password );

    String getLoginErrorMessage ();
}
