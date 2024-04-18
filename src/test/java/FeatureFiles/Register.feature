Feature: Open a new user account

  Background:
    Given User navigate to the ParaBank Website

  @Accounts,@Smoke,@Regression
  Scenario: User registration
    When User clicks the Register link
    And the user fills the fields on the screen
      | firstName       | Muharrem       |
      | lastName        | Yurtsever       |
      | address         | High Street    |
      | city            | Leicester       |
      | state           | Northamptonshire    |
      | zipCode         | NN17YTR      |
      | phoneNumber     | 78216548796 |
      | ssn             | 345         |
      | userName        | muharrem222    |
      | password        | 1234567     |
      | confirmPassword | 1234567     |

    And the user clicks the Register button
    Then user confirms that a successful registration process has taken place
