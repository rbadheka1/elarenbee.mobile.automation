# How to Write and Run Automated Tests

This guide helps you write new tests for your mobile app, following Java best practices, and enables running on simulators, emulators, and local devices.

---

## 1. Directory & Package Structure

Place your test files under:

```
src/test/java/com/elarenbee/mobile/automation/tests/
```
Create a test class per feature, e.g., `LoginTest.java`, `PaymentTest.java`, etc.

---

## 2. Test Class Template

Here’s a template for a typical test class using TestNG (or JUnit, as needed):

```java
package com.elarenbee.mobile.automation.tests;

import com.elarenbee.mobile.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Parameters({"platformName", "deviceName", "platformVersion"})
    @BeforeClass
    public void setUp(String platformName, String deviceName, String platformVersion) {
        // TODO: Initialize driver with capabilities for the specified platform/device/emulator/simulator
        // Example placeholder:
        // driver = DriverFactory.createDriver(platformName, deviceName, platformVersion);

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("Password123");
        loginPage.clickLogin();
        // TODO: Add assertions to verify successful login
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
```

---

## 3. Page Object Example

Place your page objects under:

```
src/test/java/com/elarenbee/mobile/automation/pages/
```

Example for `LoginPage.java`:

```java
package com.elarenbee.mobile.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static final By USERNAME_INPUT = By.id("username_input_id"); // TODO: Replace with actual ID
    private static final By PASSWORD_INPUT = By.id("password_input_id"); // TODO: Replace with actual ID
    private static final By LOGIN_BUTTON = By.id("login_button_id");     // TODO: Replace with actual ID

    private final WebDriver driver;

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void enterUsername(String username) { driver.findElement(USERNAME_INPUT).sendKeys(username); }
    public void enterPassword(String password) { driver.findElement(PASSWORD_INPUT).sendKeys(password); }
    public void clickLogin() { driver.findElement(LOGIN_BUTTON).click(); }
}
```

---

## 4. Running on Emulators, Simulators, or Local Devices

- **Emulator (Android) / Simulator (iOS):**  
  Configure your test runner’s capabilities:
  - `deviceName`: Name of your emulator/simulator (e.g., `emulator-5554`, `iPhone-12`)
  - `platformName`: `Android` or `iOS`
  - `platformVersion`: OS version (e.g., `14.4`)
  - `app`: Path or URL to your app (.apk or .ipa)

- **Local Device:**  
  Plug your device in, enable developer mode, and ensure it appears in `adb devices` (Android) or Xcode Devices (iOS). Set the `deviceName` to the device’s ID.

- **Sample Desired Capabilities Setup** (in a DriverFactory):

```java
// Placeholder for initializing AppiumDriver with desired capabilities
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("platformName", platformName);
caps.setCapability("deviceName", deviceName);
caps.setCapability("platformVersion", platformVersion);
caps.setCapability("app", "/path/to/app.apk"); // or .ipa for iOS
// Add more capabilities as needed

driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
// or
driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
```
Use environment variables or a config file to select device/emulator/simulator at runtime.

---

## 5. Running Your Tests

### Using Maven:
```shell
mvn test -DsuiteXmlFile=testng.xml -Dplatform=android -DdeviceName=emulator-5554
```
Replace parameters as needed for iOS or local devices.

### Using TestNG XML:
Configure `<parameter>` values in `testng.xml` for different environments.

---

## 6. Placeholders

- Replace all `TODO` comments with your app’s actual values (element locators, app path, etc.).
- Add more page object methods and assertions as needed for your flows.

---

## 7. Tips

- Keep tests independent and repeatable.
- Use @BeforeClass/@AfterClass for setup and teardown.
- Store sensitive data in `.env` or config files, not in code.
- Use page objects for all UI interactions.

---

For more advanced examples, see the `tests/` and `pages/` directories in this repo.
