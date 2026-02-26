package com.dcxmobile.pages;

import com.dcxmobile.utils.WaitUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * CallPage - Page Object for the New Call form.
 *
 * Fields visible:
 * - Subject (required), Description (required)
 * - Date, Priority (Low default), Type (Call default)
 * - Assigned to, Interaction Note, Related to and Name
 * - Additional Details section:
 *   Branch Task, Assigned to On-Call BOA,
 *   Incoming Call, Meaningful Conversation,
 *   Left a Voicemail, Completed by, Completed Date/Time
 */
public class CallPage {

    private final AppiumDriver driver;

    // ── Locators ─────────────────────────────────────────────────
    private final By subjectLabel          = AppiumBy.accessibilityId("Subject (required)");
    private final By descriptionLabel      = AppiumBy.accessibilityId("Description (required)");
    private final By subjectField          = AppiumBy.accessibilityId("Enter subject");
    private final By descriptionField      = AppiumBy.accessibilityId("Enter description");
    private final By dateField             = AppiumBy.accessibilityId("Date");
    private final By priorityField         = AppiumBy.accessibilityId("Priority");
    private final By typeField             = AppiumBy.accessibilityId("Type");
    private final By assignedToField       = AppiumBy.accessibilityId("Assigned to");
    private final By interactionNoteField  = AppiumBy.accessibilityId("Interaction Note");
    private final By relatedToField        = AppiumBy.accessibilityId("Related to and Name");
    private final By saveButton            = AppiumBy.accessibilityId("Save");

    // ── Additional Details ────────────────────────────────────────
    private final By additionalDetails     = AppiumBy.accessibilityId("Additional Details");
    private final By branchTaskToggle      = AppiumBy.accessibilityId("Branch Task");
    private final By onCallBOAToggle       = AppiumBy.accessibilityId("Assigned to On-Call BOA");
    private final By incomingCallToggle    = AppiumBy.accessibilityId("Incoming Call");
    private final By meaningfulConvToggle  = AppiumBy.accessibilityId("Meaningful Conversation");
    private final By leftVoicemailToggle   = AppiumBy.accessibilityId("Left a Voicemail");
    private final By completedByField      = AppiumBy.accessibilityId("Completed by");
    private final By completedDateField    = AppiumBy.accessibilityId("Completed Date/Time");

    public CallPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // ── Actions ──────────────────────────────────────────────────

    public void enterSubject(String subject) {
        WaitUtils.waitForVisible(driver, subjectField).sendKeys(subject);
        System.out.println("  Entered call subject: " + subject);
    }

    public void enterDescription(String description) {
        WaitUtils.waitForVisible(driver, descriptionField).sendKeys(description);
        System.out.println("  Entered call description: " + description);
    }

    public void tapSave() {
        WaitUtils.waitForClickable(driver, saveButton).click();
        System.out.println("  Tapped Save on call form");
        WaitUtils.pause(2000);
    }

    // ── Verifications ─────────────────────────────────────────────

    public boolean isNewCallFormVisible() {
        return WaitUtils.isElementPresent(driver, subjectLabel);
    }

    public boolean isSubjectFieldVisible() {
        return WaitUtils.isElementPresent(driver, subjectLabel);
    }

    public boolean isDescriptionFieldVisible() {
        return WaitUtils.isElementPresent(driver, descriptionLabel);
    }

    public boolean isDateFieldVisible() {
        return WaitUtils.isElementPresent(driver, dateField);
    }

    public boolean isPriorityFieldVisible() {
        return WaitUtils.isElementPresent(driver, priorityField);
    }

    public boolean isTypeFieldVisible() {
        return WaitUtils.isElementPresent(driver, typeField);
    }

    public boolean isAssignedToFieldVisible() {
        return WaitUtils.isElementPresent(driver, assignedToField);
    }

    public boolean isInteractionNoteVisible() {
        return WaitUtils.isElementPresent(driver, interactionNoteField);
    }

    public boolean isAdditionalDetailsVisible() {
        return WaitUtils.isElementPresent(driver, additionalDetails);
    }

    public boolean isBranchTaskToggleVisible() {
        return WaitUtils.isElementPresent(driver, branchTaskToggle);
    }

    public boolean isOnCallBOAToggleVisible() {
        return WaitUtils.isElementPresent(driver, onCallBOAToggle);
    }

    public boolean isIncomingCallToggleVisible() {
        return WaitUtils.isElementPresent(driver, incomingCallToggle);
    }

    public boolean isMeaningfulConvVisible() {
        return WaitUtils.isElementPresent(driver, meaningfulConvToggle);
    }

    public boolean isLeftVoicemailVisible() {
        return WaitUtils.isElementPresent(driver, leftVoicemailToggle);
    }
}
