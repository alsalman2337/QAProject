@swagLabs
Feature: Correct Webpage by validating title and content
  Scenario: Validating webpage title
    Given user lands on correct webpage
    Then user validates the title "Swag Labs"
    Then close the browser

  Scenario: Validating username placeholder
    Given user lands on correct webpage
    Then user validates the placeholders
    Then close the browser

  Scenario: Validating login button
    Given  user lands on correct webpage
    Then user validates the "Login" button
    Then close the browser

