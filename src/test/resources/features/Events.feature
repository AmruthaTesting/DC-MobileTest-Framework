# =============================================
# Feature: Events
# App: Edward Jones Go Mobile (CRM)
# =============================================

@Events @Regression
Feature: Edward Jones Mobile App - Create Event

  Background:
    Given I am logged in to the app
    And I tap the plus FAB button
    And I select "Event"

  @Smoke
  Scenario: Verify New Event form is displayed
    Then I should see the New Event form

  Scenario: Verify Subject is a mandatory field on Event form
    Then I should see "Subject (required)" field on the event form

  Scenario: Verify Description is a mandatory field on Event form
    Then I should see "Description (required)" field on the event form

  Scenario: Verify all fields are present on New Event form
    Then I should see "Subject (required)" field on the event form
    And I should see "Description (required)" field on the event form
    And I should see "In Office" field on the event form
    And I should see "Related to and Name" field on the event form
    And I should see "Assigned to" field on the event form
    And I should see "All-day" field on the event form
    And I should see "Date" field on the event form
    And I should see "Start time" field on the event form
    And I should see "End time" field on the event form

  @CreateEvent
  Scenario: Create a new Event with valid data
    When I fill in event subject "Test Event - Automation" and description "Created by automation test"
    And I tap the Save button
    Then the event should be saved successfully
