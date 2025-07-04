package com.elarenbee.mobile.automation.pages;

import com.elarenbee.mobile.automation.utils.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @AndroidFindBy(id = "org.wikipedia.alpha:id/text_input")
    @iOSXCUITFindBy(accessibility = "login_input")
    private MobileElement usernameField;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/password_input")
    @iOSXCUITFindBy(accessibility = "password_input")
    private MobileElement passwordField;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/login_button")
    @iOSXCUITFindBy(accessibility = "login_button")
    private MobileElement loginButton;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void tapLogin() {
        loginButton.click();
    }
}
