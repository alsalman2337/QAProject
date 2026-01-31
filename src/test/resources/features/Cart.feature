@CartTest
Feature: Shopping Cart functionality test
  Scenario: Adding single item to the cart
    Given user is logged in
    And user is on the products page
    When user adds "Sauce Labs Backpack" to the cart
    Then cart icon should show "1"
    And the cart should contain "Sauce Labs Backpack"
  Scenario: Removing item from the cart
    Given user has "Sauce Labs Backpack" in the cart
    When user removes "Sauce Labs Backpack" from the cart
    Then cart icon should show ""
    And the cart should not contain "Sauce Labs Backpack"



