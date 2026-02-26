package com.dcxmobile.pages;

import com.dcxmobile.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * EventPage - Page Object for New Event form.
 *
 * Fields visible on screen:
 * - Subject (required) - 0/255
 * - Description (required) - 0/1500
 * - In Office toggle
 * - Related to and Name
 * - Assigned to
 * - All-day toggle
 * - Date, Start time, End time
 * - Save button
 */
public class EventPage {

    private final AppiumDriver driver;

    // ── Locators ─────────────────────────────────────────────────
    private final By subjectField      = AppiumBy.accessibilityId("Enter subject");
    private final By descriptionField  = AppiumBy.accessibilityId("Enter description");
    private final By saveButton        = AppiumBy.accessibilityId("Save");
    private final By inOfficeToggle    = AppiumBy.accessibilityId("In Office");
    private final By allDayToggle      = AppiumBy.accessibilityId("All-day");
    private final By dateField         = AppiumBy.accessibilityId("Date");
    private final By startTimeField    = AppiumBy.accessibilityId("Start time");
    private final By endTimeField      = AppiumBy.accessibilityId("End time");
    private final By relatedToField    = AppiumBy.accessibilityId("Related to and Name");
    private final By assignedToField   = AppiumBy.accessibilityId("Assigned to");
    private final By subjectLabel      = AppiumBy.accessibilityId("Subject (required)");
    private final By descriptionLabel  = AppiumBy.accessibilityId("Description (required)");

    public EventPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // ── Actions ──────────────────────────────────────────────────

    public void enterSubject(String subject) {
        WaitUtils.waitForVisible(driver, subjectField).sendKeys(subject);
        System.out.println("  Entered subject: " + subject);
    }

    public void enterDescription(String description) {
        WaitUtils.waitForVisible(driver, descriptionField).sendKeys(description);
        System.out.println("  Entered description: " + description);
    }

    public void tapSave() {
        WaitUtils.waitForClickable(driver, saveButton).click();
        System.out.println("  Tapped Save");
        WaitUtils.pause(2000);
    }

    // ── Verifications ─────────────────────────────────────────────

    public boolean isNewEventFormVisible() {
        return WaitUtils.isElementPresent(driver, subjectLabel);
    }

    public boolean isSubjectFieldVisible() {
        return WaitUtils.isElementPresent(driver, subjectLabel);
    }

    public boolean isDescriptionFieldVisible() {
        return WaitUtils.isElementPresent(driver, descriptionLabel);
    }

    public boolean isInOfficeVisible() {
        return WaitUtils.isElementPresent(driver, inOfficeToggle);
    }

    public boolean isRelatedToVisible() {
        return WaitUtils.isElementPresent(driver, relatedToField);
    }

    public boolean isAssignedToVisible() {
        return WaitUtils.isElementPresent(driver, assignedToField);
    }

    public boolean isAllDayToggleVisible() {
        return WaitUtils.isElementPresent(driver, allDayToggle);
    }

    public boolean isDateFieldVisible() {
        return WaitUtils.isElementPresent(driver, dateField);
    }

    public boolean isStartTimeVisible() {
        return WaitUtils.isElementPresent(driver, startTimeField);
    }

    public boolean isEndTimeVisible() {
        return WaitUtils.isElementPresent(driver, endTimeField);
    }

    public boolean isSaveButtonVisible() {
        return WaitUtils.isElementPresent(driver, saveButton);
    }
}
