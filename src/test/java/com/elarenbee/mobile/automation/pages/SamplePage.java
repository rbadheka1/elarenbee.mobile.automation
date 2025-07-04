package com.elarenbee.mobile.automation.pages;

import com.elarenbee.mobile.automation.utils.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class SamplePage {

    @AndroidFindBy(id = "org.wikipedia.alpha:id/sample_element")
    @iOSXCUITFindBy(accessibility = "sample_element")
    private MobileElement sampleElement;

    public SamplePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean isSampleElementDisplayed() {
        return sampleElement.isDisplayed();
    }
}
