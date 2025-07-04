package com.elarenbee.mobile.automation.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Hooks {

    private static AppiumDriver<MobileElement> driver;

    @Before
    public void setUp() throws Exception {
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        String platform = System.getProperty("platform"); // "android" or "ios"
        DesiredCapabilities caps = new DesiredCapabilities();

        if ("android".equalsIgnoreCase(platform)) {
            caps.setCapability("device", "Google Pixel 7");
            caps.setCapability("os_version", "13.0");
            caps.setCapability("app", System.getenv("BROWSERSTACK_ANDROID_APP_URL"));
        } else {
            caps.setCapability("device", "iPhone 14");
            caps.setCapability("os_version", "16");
            caps.setCapability("app", System.getenv("BROWSERSTACK_IOS_APP_URL"));
        }

        caps.setCapability("project", "Elarenbee Mobile Automation");
        caps.setCapability("build", "Java Cucumber TestNG");
        caps.setCapability("name", "sample_test");

        driver = platform != null && platform.equals("android")
                ? new AndroidDriver<>(new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps)
                : new IOSDriver<>(new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}
