Feature:New Account Functionality

  Background:
    Given User navigate to the ParaBank Website
    And the user sees the Customer Login section on the home page.
    And the user fills the fields on the screen
      | loginUsername | muharrem222 |
      | loginPassword | 1234567 |
    And the user clicks the login button
    Then user confirms that a successful registration process has taken place

  @Accounts, @Smoke, @Regression
  Scenario: Open new Account
    When User clicks open new Account
    Then the User click on the Open new Account button
    And user confirms that a successful registration process has taken place