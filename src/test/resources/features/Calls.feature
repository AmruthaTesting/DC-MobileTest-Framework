# =============================================
# Feature: Calls (New Call form)
# App: Edward Jones Go Mobile (CRM)
# =============================================

@Calls @Regression
Feature: Edward Jones Mobile App - New Call

  Background:
    Given I am logged in to the app
    And I tap the plus FAB button
    And I select "Call"

  @Smoke
  Scenario: Verify New Call form is displayed
    Then I should see "Subject (required)" field on the call form
    And I should see "Description (required)" field on the call form

  Scenario: Verify all main fields on New Call form
    Then I should see "Subject (required)" field on the call form
    And I should see "Description (required)" field on the call form
    And I should see "Date" field on the call form
    And I should see "Priority" field on the call form
    And I should see "Type" field on the call form
    And I should see "Assigned to" field on the call form
    And I should see "Interaction Note" field on the call form

  Scenario: Verify Additional Details section is present
    When I scroll down on the form
    Then I should see Additional Details section

  Scenario: Verify toggles in Additional Details section
    When I scroll down on the form
    Then I should see "Branch Task" toggle in Additional Details
    And I should see "Incoming Call" toggle in Additional Details
    And I should see "Meaningful Conversation" toggle in Additional Details
    And I should see "Left a Voicemail" toggle in Additional Details
