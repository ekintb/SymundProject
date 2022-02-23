@logout
Feature: User should be able to log out and ends up in login page

  Background: the user is on the dashboard page
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login


  Scenario: Logout the page
    When the user clicks the avatar
    And the user clicks logout button
    Then the user should be able to logout



  Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    When the user clicks the avatar
    And the user clicks logout button
    And the user clicks back button
    Then the user is still on the same page