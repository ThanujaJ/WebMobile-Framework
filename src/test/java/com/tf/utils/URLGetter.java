package com.tf.utils;

public class URLGetter {

    /**
     * This method has the capability to handle cluster, staging and prod environment urls
     */

    public String getURLs ( String portalName ) {

        PropertyReader propertyReader = new PropertyReader();
        String url = propertyReader.readEnvSpecProperty(portalName);
        return url;
    }

    public String getEnvironment () {
        String environment = System.getenv("EnvironmentName");
        if (environment == null) {
            environment = new PropertyReader().readProperty("environment");
        }
        return environment;
    }
}
