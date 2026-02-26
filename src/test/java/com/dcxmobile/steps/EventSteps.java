package com.dcxmobile.steps;

import com.dcxmobile.drivers.DriverFactory;
import com.dcxmobile.pages.EventPage;
import com.dcxmobile.pages.HomePage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class EventSteps {

    private AppiumDriver driver;
    private HomePage  homePage;
    private EventPage eventPage;

    private void initPages() throws Exception {
        driver    = DriverFactory.getDriver();
        homePage  = new HomePage(driver);
        eventPage = new EventPage(driver);
    }

    @And("I tap the plus FAB button")
    public void i_tap_fab() throws Exception {
        initPages();
        homePage.tapFabButton();
    }

    @And("I select {string}")
    public void i_select_option(String option) throws Exception {
        initPages();
        switch (option.toLowerCase()) {
            case "event" -> homePage.selectEvent();
            case "task"  -> homePage.selectTask();
            case "call"  -> homePage.selectCall();
            default      -> throw new IllegalArgumentException(
                "Unknown option: " + option);
        }
    }

    @Then("I should see the New Event form")
    public void i_should_see_new_event_form() throws Exception {
        initPages();
        assertThat(eventPage.isNewEventFormVisible())
            .as("New Event form should be visible")
            .isTrue();
    }

    @Then("I should see {string} field on the event form")
    public void i_should_see_field(String fieldName) throws Exception {
        initPages();
        boolean visible = switch (fieldName) {
            case "Subject (required)"     -> eventPage.isSubjectFieldVisible();
            case "Description (required)" -> eventPage.isDescriptionFieldVisible();
            case "In Office"              -> eventPage.isInOfficeVisible();
            case "Related to and Name"    -> eventPage.isRelatedToVisible();
            case "Assigned to"            -> eventPage.isAssignedToVisible();
            case "All-day"               -> eventPage.isAllDayToggleVisible();
            case "Date"                  -> eventPage.isDateFieldVisible();
            case "Start time"            -> eventPage.isStartTimeVisible();
            case "End time"              -> eventPage.isEndTimeVisible();
            default -> throw new IllegalArgumentException(
                "Unknown field: " + fieldName);
        };
        assertThat(visible)
            .as(fieldName + " should be visible on event form")
            .isTrue();
        System.out.println("  ✅ Field visible: " + fieldName);
    }

    @When("I fill in event subject {string} and description {string}")
    public void i_fill_event_details(String subject, String description)
            throws Exception {
        initPages();
        eventPage.enterSubject(subject);
        eventPage.enterDescription(description);
    }

    @And("I tap the Save button")
    public void i_tap_save() throws Exception {
        initPages();
        eventPage.tapSave();
    }

    @Then("the event should be saved successfully")
    public void event_saved_successfully() throws Exception {
        initPages();
        assertThat(homePage.isHomeScreenVisible())
            .as("Should return to home after saving event")
            .isTrue();
        System.out.println("  ✅ Event saved successfully!");
    }
}
