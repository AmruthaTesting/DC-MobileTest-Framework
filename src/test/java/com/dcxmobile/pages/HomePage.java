package com.dcxmobile.pages;

import com.dcxmobile.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * HomePage - Page Object for the Edward Jones Home/Dashboard screen.
 *
 * Screen shows:
 * - Welcome, [Name] message
 * - Day at a Glance section
 * - Calendar strip
 * - Plus FAB button (opens Task/Event options)
 * - Bottom nav: Home, Search, Calendar, Tasks
 */
public class HomePage {

    private final AppiumDriver driver;

    // ── Locators ─────────────────────────────────────────────────
    private final By welcomeMessage  = AppiumBy.accessibilityId("Welcome");
    private final By dayAtGlance     = AppiumBy.accessibilityId("Day at a Glance");
    private final By fabButton       = AppiumBy.accessibilityId("Add");
    private final By taskOption      = AppiumBy.accessibilityId("Task");
    private final By eventOption     = AppiumBy.accessibilityId("Event");
    private final By callOption      = AppiumBy.accessibilityId("Call");
    private final By homeTabButton   = AppiumBy.accessibilityId("Home");
    private final By searchTab       = AppiumBy.accessibilityId("Search");
    private final By calendarTab     = AppiumBy.accessibilityId("Calendar");
    private final By tasksTab        = AppiumBy.accessibilityId("Tasks");

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    // ── Verifications ─────────────────────────────────────────────

    public boolean isHomeScreenVisible() {
        return WaitUtils.isElementPresent(driver, dayAtGlance);
    }

    public boolean isWelcomeMessageVisible() {
        return WaitUtils.isElementPresent(driver, welcomeMessage);
    }

    public boolean isFabButtonVisible() {
        return WaitUtils.isElementPresent(driver, fabButton);
    }

    public boolean isDayAtGlanceVisible() {
        return WaitUtils.isElementPresent(driver, dayAtGlance);
    }

    // ── Actions ──────────────────────────────────────────────────

    public void tapFabButton() {
        WaitUtils.waitForClickable(driver, fabButton).click();
        System.out.println("  Tapped FAB (+) button");
        WaitUtils.pause(1000);
    }

    public void selectTask() {
        WaitUtils.waitForClickable(driver, taskOption).click();
        System.out.println("  Selected Task");
        WaitUtils.pause(1000);
    }

    public void selectEvent() {
        WaitUtils.waitForClickable(driver, eventOption).click();
        System.out.println("  Selected Event");
        WaitUtils.pause(1000);
    }

    public void selectCall() {
        WaitUtils.waitForClickable(driver, callOption).click();
        System.out.println("  Selected Call");
        WaitUtils.pause(1000);
    }

    public void navigateToTasks() {
        WaitUtils.waitForClickable(driver, tasksTab).click();
        System.out.println("  Navigated to Tasks tab");
        WaitUtils.pause(1000);
    }

    public void navigateToCalendar() {
        WaitUtils.waitForClickable(driver, calendarTab).click();
        System.out.println("  Navigated to Calendar tab");
        WaitUtils.pause(1000);
    }

    public boolean isTaskOptionVisible() {
        return WaitUtils.isElementPresent(driver, taskOption);
    }

    public boolean isEventOptionVisible() {
        return WaitUtils.isElementPresent(driver, eventOption);
    }
}
