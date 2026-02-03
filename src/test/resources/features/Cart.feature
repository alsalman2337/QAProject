
@CartTest
Feature: Shopping Cart functionality test

  Background:
    Given user is logged in
    And user is on the products page
@test1
  Scenario: Adding single item to the cart
    When user adds "Sauce Labs Backpack" to the cart
    Then cart icon should show "1"
    And the cart should contain "Sauce Labs Backpack"
@test2
  Scenario: Removing item from the cart
    Given the cart contains "Sauce Labs Backpack"
    When user removes "Sauce Labs Backpack" from the cart
    Then cart icon should be empty
    And the cart should not contain "Sauce Labs Backpack"
@test3
  Scenario: Validating cart page and URL
    When user clicks on the cart logo user lands on the carts page
    Then user validates the "https://www.saucedemo.com/cart.html" URL
    And user validates the "Your Cart" page title







