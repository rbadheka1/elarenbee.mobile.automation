# Test Automation Help

## Java Test Structure & Reuse Best Practices

### 1. Directory Layout

Organize tests following Maven/Gradle conventions:
```
src/
  main/java/             # Production code
  test/java/             # Test code (by feature)
  test/resources/        # Test data, configs, feature files
```

### 2. Page Object Model (POM)

- **Each app screen/page:** One Java class in a `pages/` package.
- **Locators:** All as `private static final` constants at top of each Page class.
- **Constructor:** Accepts a `WebDriver` (or `AppiumDriver`) instance.
- **Methods:** Only for actions and queries on that page.

#### Example: LoginPage.java
```java
package com.example.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static final By USERNAME_INPUT = By.id("username_input_id");
    private static final By PASSWORD_INPUT = By.id("password_input_id");
    private static final By LOGIN_BUTTON = By.id("login_button_id");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) { this.driver = driver; }

    public void enterUsername(String username) { driver.findElement(USERNAME_INPUT).sendKeys(username); }
    public void enterPassword(String password) { driver.findElement(PASSWORD_INPUT).sendKeys(password); }
    public void clickLogin() { driver.findElement(LOGIN_BUTTON).click(); }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
```

### 3. Reuse & Separation

- **Common Locators:** Shared UI elements go in `CommonLocators.java`.
- **BasePage:** Shared WebDriver actions (click, type, waits) in `BasePage.java`. All page classes extend it.
- **Utils:** Helpers (random data, config) in `utils/` package.
- **Test Data:** In `src/test/resources/data/` or similar.

#### Example: BasePage.java
```java
public abstract class BasePage {
    protected final WebDriver driver;
    public BasePage(WebDriver driver) { this.driver = driver; }

    protected void click(By locator) { driver.findElement(locator).click(); }
    protected void type(By locator, String text) {
        var element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
}
```

#### Example: CommonLocators.java
```java
public class CommonLocators {
    public static final By LOGOUT_BUTTON = By.id("logout_id");
    // Add more shared locators here
}
```

---

**Summary Table**

| What                  | Where/How to Separate for Reuse                                      |
|-----------------------|---------------------------------------------------------------------|
| Shared Locators       | `CommonLocators` or a centralized class                             |
| Page Actions/Methods  | In `BasePage`, then extend in each `Page` class                     |
| Utilities             | `utils` package                                                     |
| Test Data/Config      | `src/test/resources/data/` and `src/test/resources/config/`          |
| Reusable Flows        | As methods in `BasePage` or helper classes                          |

---

_Follow these practices for maintainable, reusable, and clear test automation code!_
