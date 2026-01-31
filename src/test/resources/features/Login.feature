@LoginTest
Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given user is on the login page
    When user logs in with "standard_user" and "secret_sauce"
    Then user should see the "Products" page

  Scenario Outline: Invalid username and password validation
    Given user is on the login page
    When user logs in with "<username>" and "<password>"
    Then user should see the message "<message>"

    Examples:
      | username        | password     | message                                                                   |
      | wrong_user      | secret_user  | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | wrong_pass   | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                        |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |







