# =============================================
# Feature: Tasks
# App: Edward Jones Go Mobile (CRM)
# =============================================

@Tasks @Regression
Feature: Edward Jones Mobile App - Tasks

  Background:
    Given I am logged in to the app

  @Smoke
  Scenario: Verify Tasks screen is accessible from bottom navigation
    When I navigate to Tasks screen
    Then I should see tasks with priority labels

  Scenario: Verify Urgent priority tasks are displayed
    When I navigate to Tasks screen
    Then I should see "Urg" priority tasks

  Scenario: Verify Medium priority tasks are displayed
    When I navigate to Tasks screen
    Then I should see "Med" priority tasks

  Scenario: Verify Low priority tasks are displayed
    When I navigate to Tasks screen
    Then I should see "Low" priority tasks

  Scenario: Verify New Task form mandatory fields
    And I tap the plus FAB button
    And I select "Task"
    Then I should see "Subject (required)" field on the task form
    And I should see "Description (required)" field on the task form

  Scenario: Verify New Task form has Priority and Type fields
    And I tap the plus FAB button
    And I select "Task"
    Then I should see "Priority" field on the task form
    And I should see "Type" field on the task form
