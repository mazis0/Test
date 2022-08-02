@Test @Positive @Login
Feature: Login
  Background:
    Given User is on Greating Page
    And Click on right arrow button
    And User is On Software Description Page
    And Click on GET STARTED button
    And User is On Home Page
    And Click On Masuk button

  Scenario: User should be able to Login with valid credentials
    Given User is on Login Page
    And Input valid username and password
    And User click On Continue Button
    And Wait Until download data is completed
    When User click on closed button
    Then Verify that user is on Dashboard Page