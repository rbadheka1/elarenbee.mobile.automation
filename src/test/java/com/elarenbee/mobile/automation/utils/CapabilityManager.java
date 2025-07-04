package com.elarenbee.mobile.automation.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityManager {

    public static DesiredCapabilities getCapabilities(String platform) {
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("android")) {
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "Android Phone");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("app", System.getenv("BROWSERSTACK_ANDROID_APP_URL"));
            // Add more Android-specific capabilities as needed
        } else if (platform.equalsIgnoreCase("ios")) {
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("app", System.getenv("BROWSERSTACK_IOS_APP_URL"));
            // Add more iOS-specific capabilities as needed
        }
        // BrowserStack credentials
        caps.setCapability("browserstack.user", System.getenv("BROWSERSTACK_USERNAME"));
        caps.setCapability("browserstack.key", System.getenv("BROWSERSTACK_ACCESS_KEY"));
        return caps;
    }
}
