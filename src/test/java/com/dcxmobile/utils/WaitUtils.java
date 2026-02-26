package com.dcxmobile.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WaitUtils - Helper methods for waiting for elements.
 * Avoids hardcoded Thread.sleep() calls throughout tests.
 */
public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 30;
    private static final int SHORT_TIMEOUT   = 10;
    private static final int LONG_TIMEOUT    = 60;

    // ── Wait for element to be visible ───────────────────────────
    public static WebElement waitForVisible(AppiumDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForVisible(AppiumDriver driver, By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ── Wait for element to be clickable ─────────────────────────
    public static WebElement waitForClickable(AppiumDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
            .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ── Wait for element to be present ───────────────────────────
    public static WebElement waitForPresent(AppiumDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
            .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // ── Check if element exists (no exception) ───────────────────
    public static boolean isElementPresent(AppiumDriver driver, By locator) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(SHORT_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ── Short pause (use sparingly) ───────────────────────────────
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
