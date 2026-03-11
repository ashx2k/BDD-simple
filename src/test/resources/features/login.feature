Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given user opens the login page
    When user enters username "student"
    And user enters password "Password123"
    And user clicks login button
    Then successful login message should be displayed
