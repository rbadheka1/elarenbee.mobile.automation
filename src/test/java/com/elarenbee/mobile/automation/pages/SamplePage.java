package com.elarenbee.mobile.automation.pages;

import com.elarenbee.mobile.automation.utils.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SamplePage {

    @AndroidFindBy(id = "org.wikipedia.alpha:id/sample_element")
    @iOSXCUITFindBy(accessibility = "sample_element")
    private MobileElement sampleElement;

    private static final int TIMEOUT = 10;

    public SamplePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean isSampleElementDisplayed() {
        try {
            new WebDriverWait(DriverManager.getDriver(), TIMEOUT)
                .until(ExpectedConditions.visibilityOf(sampleElement));
            return sampleElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("Sample element not displayed: " + e.getMessage());
            return false;
        }
    }
}
