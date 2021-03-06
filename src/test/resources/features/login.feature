@login
Feature: Users should be able to login
@SYMU-1095
  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login

@SYMU-1096
  Scenario: Login with invalid username
    Given the user is on the login page
    When the user enters invalid username
    Then the user should see warning message
@SYMU-1097
  Scenario: Login with invalid password
    Given the user is on the login page
    When the user enters invalid password
    Then the user should see warning message
@SYMU-1098
  Scenario: Login with empty credentials
    Given the user is on the login page
    When the user clicks login button
    Then the user should see popup message
@SYMU-1099
    Scenario: User can see the password in a form of dots by default
      Given the user is on the login page
      Then the user can see the password in a form of dots by default
@SYMU-1100
  Scenario: User can see the password explicitly if needed
    Given the user is on the login page
    Then the user clicks eye button
    Then the user can see the password explicitly
@SYMU-1101
  Scenario: User can see the "Forgot password?" link on the login page and can see the "Reset Password" button on the next page
    Given the user is on the login page
    Then the user can see the forgot password link
    When the user clicks forgot password link
    Then the user can see the reset password button
  @SYMU-1102
  Scenario: User can see valid placeholders on Username and Password fields
    Given the user is on the login page
    Then the user can see Username or email as placeholder
    Then the user can see Password as placeholder

