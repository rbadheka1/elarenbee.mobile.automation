# Elarenbee Mobile Automation Suite

This repository contains a Java-based mobile automation framework using **Appium**, **Cucumber**, **TestNG**, and **BrowserStack**. It supports both Android and iOS automated UI testing.

---

## Project Structure

```
.
├── Jenkinsfile
├── pom.xml
├── testng.xml
├── README.md
└── src
    └── test
        ├── java
        │   └── com
        │       └── elarenbee
        │           └── mobile
        │               └── automation
        │                   ├── runner
        │                   │   └── TestRunner.java
        │                   └── steps
        │                       ├── Hooks.java
        │                       ├── SampleSteps.java
        │                       └── LoginSteps.java
        └── resources
            └── features
                ├── sample.feature
                └── login.feature
```

## Prerequisites

- Java 11+
- Maven 3.6+
- Appium (no local server needed for BrowserStack)
- BrowserStack account (set environment variables: `BROWSERSTACK_USERNAME`, `BROWSERSTACK_ACCESS_KEY`, `BROWSERSTACK_ANDROID_APP_URL`, `BROWSERSTACK_IOS_APP_URL`)

## Sample Apps for Testing

You can use these public sample apps for your mobile automation:

**BrowserStack Sample Apps:**

- **Android APK:** [WikipediaSample.apk](https://www.browserstack.com/app-automate/sample-apps/android/WikipediaSample.apk)
- **iOS IPA:** [WikipediaSample.ipa](https://www.browserstack.com/app-automate/sample-apps/ios/WikipediaSample.ipa)

**Sauce Labs Sample Apps:**

- [Sauce Labs Demo Apps (Android/iOS)](https://github.com/saucelabs/sample-app-mobile/releases)

**Appium Open Source Demos:**

- [ApiDemos (Android)](https://github.com/appium/sample-code/tree/master/sample-code/apps)
- [TestApp (iOS)](https://github.com/appium/sample-code/tree/master/sample-code/apps)

**How to use:**
1. Download the APK/IPA file.
2. Upload it to BrowserStack (via Dashboard or API).
3. Use the resulting `bs://` app URL in your `BROWSERSTACK_ANDROID_APP_URL` or `BROWSERSTACK_IOS_APP_URL` environment variable.

---

## How to Run

### 1. Set Environment Variables

```sh
export BROWSERSTACK_USERNAME=your_username
export BROWSERSTACK_ACCESS_KEY=your_accesskey
export BROWSERSTACK_ANDROID_APP_URL=bs://<android-app-id>
export BROWSERSTACK_IOS_APP_URL=bs://<ios-app-id>
```

### 2. Execute TestNG Suite

For Android:
```sh
mvn clean test -DsuiteXmlFile=testng.xml -Dplatform=android
```

For iOS:
```sh
mvn clean test -DsuiteXmlFile=testng.xml -Dplatform=ios
```

Or run both by default using the `testng.xml`.

### 3. Reports

- HTML report: `target/cucumber-html-report`
- JSON report: `target/cucumber.json`

## Writing Tests

- Step definitions go in `src/test/java/com/elarenbee/mobile/automation/steps/`
- Feature files go in `src/test/resources/features/`

## Contributing

1. Fork the repo
2. Create your feature branch (`git checkout -b feature/my-feature`)
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

---

**Happy Testing!**
