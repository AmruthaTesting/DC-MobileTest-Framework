# =============================================
# Feature: Login
# App: Edward Jones Go Mobile (CRM)
# Device : iPhone 15 pro/iOS 18.5
# Jira : BMX Thundercats 26.1.3
# =============================================

@Login @Regression
Feature: Edward Jones Mobile App - Login

  Background:
    Given I launch the Edward Jones app

  @Smoke
  Scenario: Successful login with valid credentials
    When I enter valid username and password
    And I tap the Next button
    Then I should see the home screen with welcome message

  @Smoke
  Scenario: Verify FAB button is visible after login
    When I enter valid username and password
    And I tap the Next button
    Then I should see the plus FAB button on home screen

  Scenario: Verify Day at a Glance section after login
    When I enter valid username and password
    And I tap the Next button
    Then I should see "Day at a Glance" section on home screen
