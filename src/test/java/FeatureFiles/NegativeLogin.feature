Feature: Login functionality

  Background:
    Given User navigate to the ParaBank Website

  Scenario: Login with valid user information
    And the user sees the Customer Login section on the home page.
    And the user fills the fields on the screen
      | loginUsername | muharrem222  |
      | loginPassword | 123456744 |
    And the user clicks the login button
    Then The user confirms the error message that appears on the screen.