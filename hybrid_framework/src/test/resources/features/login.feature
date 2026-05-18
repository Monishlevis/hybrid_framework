Feature: Login functionality

  @smoke
  Scenario: Valid login
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user should be navigated to dashboard

  @regression
  Scenario: Invalid login
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user should see error message