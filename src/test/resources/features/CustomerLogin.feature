Feature: Customer registration
  Every anonymous customer has possibility to register if registration form is filled correctly

  Scenario: Successful registration
    Given anonymous customer is on registration page
    When registration form is filled correctly
    Then customer is logged in
    And redirected to my account page