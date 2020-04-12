@market
Feature: Marketing app test suite

  @market1
  Scenario: Market basic test
    Given I go to "quote" page
    And I print details in console
    Given I go to "google" page
    And I go to "quote" page
    And I go back and forward, then refresh the page
    When I fill out required fields
    And I submit the form
    And I click on element with xpath "//button[@id='return']"
    And I change resolution to "phone"
    And I wait for 3 sec
    And I change resolution to "desktop"
    When I verify email field behavior
    And I wait for 3 sec
    Then I verify required fields
    And I submit the form
    And I wait for 3 sec

  @market2
  Scenario: Market optional fields
    Given I go to "quote" page
    When I fill out required fields
    When I fill out optional fields
    And I submit the form
    Then I verify required fields
    Then I verify optional fields

  @market3
  Scenario: Printing logs
    Given I go to "yahoo" page
    And I print logs to the console

  @market4
  Scenario: Multi-Select
    Given I go to "quote" page
    And I fill multi-select
    














