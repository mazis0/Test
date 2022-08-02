@producer
Feature: Producer
  Background:
    Given User is on Greating Page
    And Click on right arrow button
    And User is On Software Description Page
    And Click on GET STARTED button
    And User is On Home Page
    And Click On Masuk button
    And User is on Login Page
    And Input valid username and password
    And User click On Continue Button
    And Wait Until download data is completed
    When User click on closed button
    Then Verify that user is on Dashboard Page
    And Click on label Producer

  Scenario: Add new Producer
    Given User is on Producer Page
    And Click on Add button
    And User is on Producer General Data Page
    And Scroll down until element Producers Blood Type

