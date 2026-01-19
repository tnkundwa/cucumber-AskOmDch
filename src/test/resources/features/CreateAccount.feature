Feature: Creating an Account

  Scenario: Creating an account using valid information
    Given I'm at the Accounts Page
    When I sign up with valid credentials
      | Username  | email              | password  |
      | t_nkundwa | tnkundwa@gmail.com | t_nkundwa |
    Then I should be taken to the accounts page of my personal account
    And I should receive a successful message