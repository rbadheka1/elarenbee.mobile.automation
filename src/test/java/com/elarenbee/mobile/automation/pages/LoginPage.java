package com.elarenbee.mobile.automation.pages;

import com.elarenbee.mobile.automation.utils.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    private static final int TIMEOUT = 10;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void enterUsername(String username) {
        try {
            new WebDriverWait(DriverManager.getDriver(), TIMEOUT)
                .until(ExpectedConditions.visibilityOf(usernameField));
            usernameField.clear();
            usernameField.sendKeys(username);
        } catch (Exception e) {
            System.out.println("Failed to enter username: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            new WebDriverWait(DriverManager.getDriver(), TIMEOUT)
                .until(ExpectedConditions.visibilityOf(passwordField));
            passwordField.clear();
            passwordField.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Failed to enter password: " + e.getMessage());
        }
    }

    public void tapLogin() {
        try {
            new WebDriverWait(DriverManager.getDriver(), TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButton.click();
        } catch (Exception e) {
            System.out.println("Failed to tap login: " + e.getMessage());
        }
    }

    public boolean isLoginButtonDisplayed() {
        try {
            return loginButton.isDisplayed();
        } catch (Exception e) {
            System.out.println("Login button not displayed: " + e.getMessage());
            return false;
        }
    }
}
