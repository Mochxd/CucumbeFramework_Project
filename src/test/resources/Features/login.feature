@loginTest
Feature: Login to HRM Application

  Background:
    Given The User is on HRMLogin page

  @ValidCredentials
  Scenario: Login with valid credentials
    When The User enters username as "Admin" and password as "admin123"
    Then The User should be able to login successfully and the Dashboard page open

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    When The User enters username as "<username>" and password as "<password>"
    Then The User should be able to see error message <errorMessage>

    Examples:
      | username   | password   | errorMessage        |
      | Admin      | admin12$$  | Invalid credentials |
      | admin$$    | admin123   | Invalid credentials |
      | abc123     | xyz$$      | Invalid credentials |