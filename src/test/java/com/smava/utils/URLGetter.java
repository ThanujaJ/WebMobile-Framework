package com.smava.utils;

public class URLGetter {

    /**
     *        This method has the capability to handle cluster, staging and prod environment urls
     */
    public String getURLs(String portalName) {

        PropertyReader propertyReader = new PropertyReader();
        String url = propertyReader.readEnvSpecProperty(portalName);
        //String environment = getEnvironment();

//        if (!environment.toLowerCase().contains("PROD")) {
//            return "https://" + environment + url;
//        } else {
//            System.out.println(url);
            return url;
//        }
    }

    public String getEnvironment() {
        String environment = System.getenv("EnvironmentName");
        if( environment == null ) {
            environment = new PropertyReader().readProperty("environment");
        }
        return environment;
    }
}
