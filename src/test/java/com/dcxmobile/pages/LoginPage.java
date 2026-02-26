package com.dcxmobile.pages;

import com.dcxmobile.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * LoginPage - Page Object for the Edward Jones Login screen.
 *
 * Screens covered:
 * - P/J Number + Password entry (iOS Apple Security flow)
 * - Username + Password entry (standard flow)
 * - Next / Log In button
 */
public class LoginPage {

    private final AppiumDriver driver;

    // ── iOS Locators ─────────────────────────────────────────────
    private final By usernameFieldIOS  = AppiumBy.accessibilityId("User Name");
    private final By passwordFieldIOS  = AppiumBy.accessibilityId("Password");
    private final By nextButtonIOS     = AppiumBy.accessibilityId("Next");
    private final By loginButtonIOS    = AppiumBy.accessibilityId("Log In");

    // ── Android Locators ─────────────────────────────────────────
    private final By usernameFieldAndroid = By.xpath(
        "//android.widget.EditText[@content-desc='User Name']");
    private final By passwordFieldAndroid = By.xpath(
        "//android.widget.EditText[@content-desc='Password']");
    private final By nextButtonAndroid    = By.xpath(
        "//android.widget.Button[@text='Next']");

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // ── Actions ──────────────────────────────────────────────────

    public void enterUsername(String username) {
        WebElement field = WaitUtils.waitForVisible(driver, usernameFieldIOS);
        field.clear();
        field.sendKeys(username);
        System.out.println("  Entered username: " + username);
    }

    public void enterPassword(String password) {
        WebElement field = WaitUtils.waitForVisible(driver, passwordFieldIOS);
        field.sendKeys(password);
        System.out.println("  Entered password: ****");
    }

    public void tapNextButton() {
        WaitUtils.waitForClickable(driver, nextButtonIOS).click();
        System.out.println("  Tapped Next button");
        WaitUtils.pause(2000); // wait for home screen to load
    }

    public void tapLoginButton() {
        WaitUtils.waitForClickable(driver, loginButtonIOS).click();
        System.out.println("  Tapped Log In button");
        WaitUtils.pause(2000);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapNextButton();
    }

    // ── Verifications ─────────────────────────────────────────────

    public boolean isLoginScreenVisible() {
        return WaitUtils.isElementPresent(driver, usernameFieldIOS);
    }

    public boolean isUsernameFieldVisible() {
        return WaitUtils.isElementPresent(driver, usernameFieldIOS);
    }

    public boolean isPasswordFieldVisible() {
        return WaitUtils.isElementPresent(driver, passwordFieldIOS);
    }

    public boolean isNextButtonVisible() {
        return WaitUtils.isElementPresent(driver, nextButtonIOS);
    }
}
