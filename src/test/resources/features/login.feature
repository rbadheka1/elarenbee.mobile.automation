Feature: Login Feature

  Scenario: Successful login
    Given the user is on the login screen
    When the user enters valid credentials
    Then the user should be logged in successfully
