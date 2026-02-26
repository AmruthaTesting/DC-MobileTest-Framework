package com.dcxmobile.steps;

import com.dcxmobile.drivers.DriverFactory;
import com.dcxmobile.pages.CallPage;
import com.dcxmobile.utils.ScrollUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CallSteps {

    private AppiumDriver driver;
    private CallPage callPage;

    private void initPages() throws Exception {
        driver   = DriverFactory.getDriver();
        callPage = new CallPage(driver);
    }

    @When("I scroll down on the form")
    public void i_scroll_down() throws Exception {
        initPages();
        ScrollUtils.scrollDown(driver);
        System.out.println("  Scrolled down on form");
    }

    @Then("I should see {string} field on the call form")
    public void i_should_see_call_field(String fieldName) throws Exception {
        initPages();
        boolean visible = switch (fieldName) {
            case "Subject (required)"     -> callPage.isSubjectFieldVisible();
            case "Description (required)" -> callPage.isDescriptionFieldVisible();
            case "Date"                   -> callPage.isDateFieldVisible();
            case "Priority"               -> callPage.isPriorityFieldVisible();
            case "Type"                   -> callPage.isTypeFieldVisible();
            case "Assigned to"            -> callPage.isAssignedToFieldVisible();
            case "Interaction Note"       -> callPage.isInteractionNoteVisible();
            default -> throw new IllegalArgumentException(
                "Unknown field: " + fieldName);
        };
        assertThat(visible)
            .as(fieldName + " should be visible on call form")
            .isTrue();
        System.out.println("  ✅ Call field visible: " + fieldName);
    }

    @Then("I should see {string} toggle in Additional Details")
    public void i_should_see_toggle(String toggleName) throws Exception {
        initPages();
        boolean visible = switch (toggleName) {
            case "Branch Task"              -> callPage.isBranchTaskToggleVisible();
            case "Assigned to On-Call BOA"  -> callPage.isOnCallBOAToggleVisible();
            case "Incoming Call"            -> callPage.isIncomingCallToggleVisible();
            case "Meaningful Conversation"  -> callPage.isMeaningfulConvVisible();
            case "Left a Voicemail"         -> callPage.isLeftVoicemailVisible();
            default -> throw new IllegalArgumentException(
                "Unknown toggle: " + toggleName);
        };
        assertThat(visible)
            .as(toggleName + " toggle should be visible")
            .isTrue();
        System.out.println("  ✅ Toggle visible: " + toggleName);
    }

    @Then("I should see Additional Details section")
    public void i_should_see_additional_details() throws Exception {
        initPages();
        assertThat(callPage.isAdditionalDetailsVisible())
            .as("Additional Details section should be visible")
            .isTrue();
        System.out.println("  ✅ Additional Details section visible!");
    }
}
