package com.elarenbee.mobile.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            System.out.println("Could not load config.properties, relying on environment variables.");
        }
    }

    public static String getProperty(String key) {
        // Prefer environment variable over properties file
        String envValue = System.getenv(key);
        if (envValue != null) {
            return envValue;
        }
        String propValue = properties.getProperty(key);
        // If property is encrypted, decrypt it
        if (propValue != null && propValue.startsWith("ENC(") && propValue.endsWith(")")) {
            return CredentialManager.decrypt(propValue);
        }
        return propValue;
    }
}
