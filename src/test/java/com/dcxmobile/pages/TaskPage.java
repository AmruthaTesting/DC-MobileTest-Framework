package com.dcxmobile.pages;

import com.dcxmobile.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * TaskPage - Page Object for Tasks screen and New Task form.
 *
 * Tasks screen shows:
 * - Task list with Urg/Med/Low priority badges
 * - Call type, Upcoming status
 * - Details button per task
 * - FAB + button
 *
 * New Task form:
 * - Subject (required), Description (required)
 * - Priority, Type, Date
 * - Assigned to
 */
public class TaskPage {

    private final AppiumDriver driver;

    // ── Tasks List Locators ───────────────────────────────────────
    private final By tasksScreenTitle  = AppiumBy.accessibilityId("Tasks");
    private final By urgPriorityBadge  = AppiumBy.accessibilityId("Urg");
    private final By medPriorityBadge  = AppiumBy.accessibilityId("Med");
    private final By lowPriorityBadge  = AppiumBy.accessibilityId("Low");
    private final By detailsButton     = AppiumBy.accessibilityId("Details");
    private final By callTypeLabel     = AppiumBy.accessibilityId("Call");
    private final By upcomingLabel     = AppiumBy.accessibilityId("Upcoming");

    // ── New Task Form Locators ────────────────────────────────────
    private final By subjectField      = AppiumBy.accessibilityId("Enter subject");
    private final By descriptionField  = AppiumBy.accessibilityId("Enter description");
    private final By subjectLabel      = AppiumBy.accessibilityId("Subject (required)");
    private final By descriptionLabel  = AppiumBy.accessibilityId("Description (required)");
    private final By priorityField     = AppiumBy.accessibilityId("Priority");
    private final By typeField         = AppiumBy.accessibilityId("Type");
    private final By assignedToField   = AppiumBy.accessibilityId("Assigned to");
    private final By saveButton        = AppiumBy.accessibilityId("Save");

    public TaskPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // ── Actions ──────────────────────────────────────────────────

    public void enterSubject(String subject) {
        WaitUtils.waitForVisible(driver, subjectField).sendKeys(subject);
        System.out.println("  Entered task subject: " + subject);
    }

    public void enterDescription(String description) {
        WaitUtils.waitForVisible(driver, descriptionField).sendKeys(description);
        System.out.println("  Entered task description: " + description);
    }

    public void tapSave() {
        WaitUtils.waitForClickable(driver, saveButton).click();
        System.out.println("  Tapped Save on task form");
        WaitUtils.pause(2000);
    }

    // ── Verifications ─────────────────────────────────────────────

    public boolean isTasksScreenVisible() {
        return WaitUtils.isElementPresent(driver, tasksScreenTitle);
    }

    public boolean isUrgentTaskVisible() {
        return WaitUtils.isElementPresent(driver, urgPriorityBadge);
    }

    public boolean isMediumTaskVisible() {
        return WaitUtils.isElementPresent(driver, medPriorityBadge);
    }

    public boolean isLowTaskVisible() {
        return WaitUtils.isElementPresent(driver, lowPriorityBadge);
    }

    public boolean isSubjectFieldVisible() {
        return WaitUtils.isElementPresent(driver, subjectLabel);
    }

    public boolean isDescriptionFieldVisible() {
        return WaitUtils.isElementPresent(driver, descriptionLabel);
    }

    public boolean isPriorityFieldVisible() {
        return WaitUtils.isElementPresent(driver, priorityField);
    }

    public boolean isTypeFieldVisible() {
        return WaitUtils.isElementPresent(driver, typeField);
    }

    public boolean isSaveButtonVisible() {
        return WaitUtils.isElementPresent(driver, saveButton);
    }
}
