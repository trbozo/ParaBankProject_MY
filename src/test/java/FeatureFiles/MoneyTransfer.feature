Feature: Money transfer between bank account

  Background:
    Given User navigate to the ParaBank Website
    And the user sees the Customer Login section on the home page.
    And the user fills the fields on the screen
      | loginUsername | muharrem222 |
      | loginPassword | 1234567 |
    And the user clicks the login button
    Then user confirms that a successful registration process has taken place

  @Payment,@Regression
  Scenario: User applies Money transfer
    When User clicks open Transfer Funds
    And User chooses sender and receiver account
    And the user fills the fields on the screen
      | amount | 100 |

    And User clicks Transfer button
    Then User verifies Transfer funds
    And User clicks  Accounts Overview
    And User clics Account Number
    Then User verifies transfer date and Amount in account

