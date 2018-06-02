package com.smava.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sudhanva on 5/30/18
 * @project smava
 */

public class PropertyReader {

    Properties envProperties = new Properties();
    Properties envSpecProperties = new Properties();
    public static PropertyReader instance;
    InputStream inputStreamConfig;
    InputStream inputStreamEnvSpecConfig;

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }

    public PropertyReader() {
        getConfigProperties();
    }

    private void getConfigProperties() {
        try {
                inputStreamConfig = new FileInputStream("config.properties");
                envProperties.load(inputStreamConfig);
                loadPropertiesPerEnv();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void loadPropertiesPerEnv() {
        try {
            String environment = System.getenv("EnvironmentName");
            if( environment == null ) {
                environment = envProperties.getProperty("environment");
            }
            if (environment.toLowerCase().equalsIgnoreCase("PROD")) {
                inputStreamEnvSpecConfig = new FileInputStream(envProperties.getProperty("prodPropertyFilePath"));
            } else if (environment.toLowerCase().contains("OFFLINE")) {
                inputStreamEnvSpecConfig = new FileInputStream(envProperties.getProperty("prod-offlinePropertyFilePath"));
            } else {
                inputStreamEnvSpecConfig = new FileInputStream(envProperties.getProperty("non-prodPropertyFilePath"));
            }
            envSpecProperties.load(inputStreamEnvSpecConfig);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public String readProperty(String key) { return envProperties.getProperty(key);}

    public String readEnvSpecProperty(String key) {
        return envSpecProperties.getProperty(key);
    }
}
