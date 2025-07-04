spackage com.elarenbee.mobile.automation.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityManager {

    public static DesiredCapabilities getCapabilities(String platform) {
        DesiredCapabilities caps = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("android")) {
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "Android Phone");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("app", ConfigReader.getProperty("BROWSERSTACK_ANDROID_APP_URL"));
        } else if (platform.equalsIgnoreCase("ios")) {
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("app", ConfigReader.getProperty("BROWSERSTACK_IOS_APP_URL"));
        }
        // BrowserStack credentials
        caps.setCapability("browserstack.user", ConfigReader.getProperty("browserstack.username"));
        caps.setCapability("browserstack.key", ConfigReader.getProperty("browserstack.accesskey"));
        return caps;
    }
}
