package com.elarenbee.mobile.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver<MobileElement>> driver = new ThreadLocal<>();

    public static void setDriver(AppiumDriver<MobileElement> driverInstance) {
        driver.set(driverInstance);
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
